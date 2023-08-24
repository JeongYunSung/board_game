package com.yunseong.model.common.provider

import com.yunseong.model.board.Board
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone

object BoardUtils {

    fun createBoard(t: BoardTest): Board {
        val board = Board(t.size)

        t.value.forEach {
            val boardContent = it.split(t.delimiter)
            board.putStone(Scala(boardContent[0].toInt(), boardContent[1].toInt()), Stone.from(boardContent[2]))
        }

        return board
    }
}