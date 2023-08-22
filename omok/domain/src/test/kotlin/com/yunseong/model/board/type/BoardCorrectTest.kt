package com.yunseong.model.board.type

import com.yunseong.model.board.Board
import com.yunseong.model.board.Move
import com.yunseong.model.common.provider.BoardTest
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone
import org.assertj.core.api.Assertions.assertThat

class BoardCorrectTest {

    @BoardTest
    fun `보드에 검은 돌 내려놓는 테스트`(board: Board) {
        // given
        val scala = Scala(0, 0)

        // when
        board.putStone(scala, Stone.Black)

        // then
        board[scala].let {
            assertThat(it.isStone()).isTrue()
            assertThat(it).isEqualTo(Stone.Black)
        }
    }

    @BoardTest(
        value = ["0,0,black"]
    )
    fun `(0,0)에서 (1,2)로 위치 이동 테스트`(board: Board) {
        // given
        val srcPos = Scala(0, 0)
        val dstPos = Scala(1, 2)

        // when
        board.moveStone(Move(srcPos, dstPos))

        // then
        board[srcPos].let {
            assertThat(it.isStone()).isFalse()
            assertThat(it).isEqualTo(Stone.Empty)
        }
        board[dstPos].let {
            assertThat(it.isStone()).isTrue()
            assertThat(it).isEqualTo(Stone.Black)
        }
    }

    @BoardTest(
        ["0,0,black"]
    )
    fun `검정돌을 찾는 테스트`(board: Board) {
        // given
        val srcPos = Scala(0, 0)

        // when
        val blackStone = board[srcPos]

        // then
        assertThat(blackStone).isEqualTo(Stone.Black)
    }
}
