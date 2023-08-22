package com.yunseong.model.common.provider

import com.yunseong.model.board.Board
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.AnnotationConsumer
import java.util.stream.Stream

class BoardArgumentsProvider : ArgumentsProvider, AnnotationConsumer<BoardTest> {

    private lateinit var board: Board

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(board)
        )
    }

    override fun accept(t: BoardTest) {
        val board = Board(t.size)

        t.value.forEach {
            val boardContent = it.split(t.delimiter)
            board.putStone(Scala(boardContent[0].toInt(), boardContent[1].toInt()), Stone.from(boardContent[2]))
        }
        this.board = board
    }
}
