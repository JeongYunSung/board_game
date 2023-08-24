package com.yunseong.model.rules

import com.yunseong.model.position.Direction.Companion.line
import com.yunseong.model.scan.FootPrint
import com.yunseong.model.scan.MoveState
import com.yunseong.model.scan.Road
import com.yunseong.model.scan.ScanContainer

class TwinThreeRule : Rule {

    override fun test(container: ScanContainer): RuleResult {
        var count = 0

        for (pair in line) {
            val compare = compare(container[pair.first], container[pair.second])

            println("${pair.first} $compare")

            if (compare) {
                count += 1

                if (count >= 2) {
                    return RuleResult.DENY
                }
            }
        }

        return RuleResult.ACCEPT
    }

    private fun compare(left: Road, right: Road): Boolean {
        if (left.totalCount() + right.totalCount() < 6) {
            return false
        }

        return isTriple(left.iterator(), right.iterator()) || isTriple(right.iterator(), left.iterator())
    }

    private fun isTriple(iterator: Iterator<FootPrint>, assistantIterator: Iterator<FootPrint>): Boolean {
        val (first, second) = arrayOf(iterator.next(), iterator.next())

        println("${first.state} ${second.state}")

        // [0][B]XO[O]
        // [0][B]OX[O]
        // [B]OO
        val shape = when {
            first.state == MoveState.EMPTY && second.state == MoveState.SAME ||
                first.state == MoveState.SAME && second.state == MoveState.EMPTY -> if (iterator.next().state == MoveState.SAME) 0 else 1
            first.state == MoveState.SAME && second.state == MoveState.SAME -> 0
            else -> 2
        }

        return when (shape) {
            0 -> filter(iterator, assistantIterator)
            1 -> if (assistantIterator.next().state == MoveState.SAME) {
                filter(iterator, assistantIterator)
            } else {
                false
            }
            else -> false
        }
    }

    private fun filter(iterator: Iterator<FootPrint>, assistantIterator: Iterator<FootPrint>): Boolean {
        val (first, second) = arrayOf(iterator.next(), iterator.next())
        val (assistFirst, assistSecond) = arrayOf(assistantIterator.next(), assistantIterator.next())

        return first.state == MoveState.EMPTY && assistFirst.state == MoveState.EMPTY &&
            (second.state == MoveState.EMPTY || assistSecond.state == MoveState.EMPTY)
    }
}
