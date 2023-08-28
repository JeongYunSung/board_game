package com.yunseong.model.board.printer

import com.yunseong.model.board.Board
import com.yunseong.model.board.BoardPrinter
import com.yunseong.model.position.Scala

class SimplePrinter : BoardPrinter {

    override fun print(board: Board) {
        for (y in 0 until board.height) {
            print("-")
            println("-".repeat(board.width * 4))
            for (x in 0 until board.width) {
                print("| ${board[Scala(x, y)]} ")
            }
            println("|")
        }
        print("-")
        println("-".repeat(board.width * 4))
    }
}