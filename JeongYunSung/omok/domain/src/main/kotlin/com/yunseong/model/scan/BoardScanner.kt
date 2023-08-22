package com.yunseong.model.scan

import com.yunseong.model.board.Board
import com.yunseong.model.position.Direction
import com.yunseong.model.position.Scala
import com.yunseong.model.store.Stone

class BoardScanner(
    private val board: Board
) {

    fun scan(stone: Stone, source: Scala): Map<Direction, List<FootPrint>> {
        val scan = hashMapOf<Direction, MutableList<FootPrint>>()

        for (d in Direction.entries) {
            val dVec = d.toVector()
            val history = mutableListOf<FootPrint>()

            var tempVector = dVec.fromScala(source)

            var index = -1

            for (i in 0..5) {
                val tempScala = tempVector.toScala()

                if (tempScala.x >= board.width || tempScala.y >= board.height || tempScala.x < 0 || tempScala.y < 0) {
                    history.add(FootPrint(MoveState.WALL, 1))
                    break
                }

                val newStone = board[tempScala]

                val state = when (newStone) {
                    stone -> {
                        MoveState.SAME
                    }
                    Stone.Empty -> {
                        MoveState.EMPTY
                    }
                    else -> {
                        MoveState.DIFFERENT
                    }
                }

                if (history.isNotEmpty() && history[index].state == state) {
                    history[index] = FootPrint(history[index].state, history[index].count + 1)
                } else {
                    history.add(FootPrint(state, 1))
                    index++
                }

                tempVector = tempVector.addScala(dVec.scala)
            }
            scan[d] = history
        }

        return scan
    }
}