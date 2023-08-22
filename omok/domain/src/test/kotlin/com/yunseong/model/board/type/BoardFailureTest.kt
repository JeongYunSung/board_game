package com.yunseong.model.board.type

import com.yunseong.model.board.Board
import com.yunseong.model.board.Move
import com.yunseong.model.common.provider.BoardTest
import com.yunseong.model.position.Scala
import com.yunseong.model.store.Stone
import org.junit.jupiter.api.assertThrows

class BoardFailureTest {

    @BoardTest(
        value = ["0,0,black", "1,1,white"]
    )
    fun `움직일 때 실패하는 케이스 테스트 (이미 존재, 범위 밖)`(board: Board) {
        // given
        val existSrcPos = Scala(0, 0)
        val existDstPos = Scala(1, 1)

        val outRangeSrcPos = Scala(0, 0)
        val outRangeDstPos = Scala(4, 4)

        // when // then
        assertThrows<IllegalStateException> {
            board.moveStone(Move(existSrcPos, existDstPos))
        }

        assertThrows<IllegalArgumentException> {
            board.moveStone(Move(outRangeSrcPos, outRangeDstPos))
        }
    }

    @BoardTest(
        value = ["0,0,black"]
    )
    fun `돌을 둘 때 실패한 케이스 (이미 존재, 범위 밖)`(board: Board) {
        // given
        val existPos = Scala(0, 0)
        val outRangePos = Scala(4, 4)

        // when // then
        assertThrows<IllegalStateException> {
            board.putStone(existPos, Stone.White)
        }

        assertThrows<IllegalArgumentException> {
            board.putStone(outRangePos, Stone.White)
        }
    }

    @BoardTest
    fun `범위 밖의 돌을 찾는 테스트`(board: Board) {
        // given
        val outRangePos = Scala(4, 4)

        // when // then
        assertThrows<IllegalArgumentException> {
            board.findStone(outRangePos)
        }
    }
}
