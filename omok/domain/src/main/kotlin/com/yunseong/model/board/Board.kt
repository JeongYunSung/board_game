package com.yunseong.model.board

import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone

data class Board(
    private val size: Int
) {
    private val stones: MutableList<Stone> = MutableList(size * size) { Stone.Empty }

    val width = size
    val height = size

    fun findStone(scala: Scala): Stone {
        checkRange(scala)

        return stones[(scala.y * size) + scala.x]
    }

    fun moveStone(move: Move) {
        checkRange(move.from, move.to)

        val srcPos = (move.from.y * size) + move.from.x
        val destPos = (move.to.y * size) + move.to.x

        check(stones[srcPos].isStone() && !stones[destPos].isStone()) {
            "source position is empty or destination position is not empty"
        }

        stones[destPos] = stones[srcPos]
        stones[srcPos] = Stone.Empty
    }

    fun putStone(scala: Scala, stone: Stone) {
        checkRange(scala)

        val pos = (scala.y * size) + scala.x

        check(!stones[pos].isStone()) {
            "position is not empty"
        }

        stones[pos] = stone
    }

    fun printBoard() {
        for (y in 0 until size) {
            print("-")
            println("-".repeat(size * 4))
            for (x in 0 until size) {
                print("| ${stones[(y * size) + x]} ")
            }
            println("|")
        }
        print("-")
        println("-".repeat(size * 4))
    }

    fun clear() {
        stones.fill(Stone.Empty)
    }

    operator fun set(scala: Scala, stone: Stone) = putStone(scala, stone)

    operator fun get(scala: Scala) = findStone(scala)

    private fun checkRange(vararg scala: Scala) {
        scala.firstOrNull {
            it.x >= size || it.y >= size
        }?.let {
            throw IllegalArgumentException("position is out of range in board")
        }
    }
}
