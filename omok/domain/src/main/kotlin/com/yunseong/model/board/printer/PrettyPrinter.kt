package com.yunseong.model.board.printer

import com.yunseong.model.board.Board
import com.yunseong.model.board.BoardPrinter
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone

class PrettyPrinter : BoardPrinter {

    override fun print(board: Board) {
        val printBoard = Array(board.height) { Array(board.width) { "╋" } }

        var (x, y) = 1 to 0
        var (dx, dy) = 1 to 0
        var shape = "┳"

        while (true) {
            var isPrint = true
            when {
                x == board.width-1 && dx == 1 -> {
                    dx = 0
                    dy = 1
                    shape = "┫"
                    printBoard[y][x] = "┓"
                    isPrint = false
                }
                y == board.height-1 && dy == 1 -> {
                    dx = -1
                    dy = 0
                    shape = "┻"
                    printBoard[y][x] = "┛"
                    isPrint = false
                }
                x == 0 && dx == -1 -> {
                    dx = 0
                    dy = -1
                    shape = "┣"
                    printBoard[y][x] = "┗"
                    isPrint = false
                }
                y == 0 && dy == -1 -> {
                    printBoard[y][x] = "┏"
                    break
                }
            }
            if (isPrint) {
                printBoard[y][x] = shape
            }
            x += dx
            y += dy
        }

        for (by in 0 until board.height) {
            for (bx in 0 until board.width) {
                val stone = board[Scala(bx, by)]

                if (stone == Stone.White) {
                    printBoard[by][bx] = "○"
                } else if (stone == Stone.Black) {
                    printBoard[by][bx] = "●"
                }
            }
        }

        printBoard.forEach {
            it.forEach { content ->
                print(content)
            }
            println()
        }
    }
}