package com.yunseong.model.scan

import com.yunseong.model.board.Board
import com.yunseong.model.common.provider.BoardTest
import com.yunseong.model.position.Direction
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone
import org.assertj.core.api.Assertions.assertThat

class BoardScannerTest {

    @BoardTest(
        value = [
            "2,5,black",
            "3,3,black", "3,4,black", "3,6,black", "3,7,black",
            "4,5,white"
        ],
        size = 8
    )
    fun `보드 스캔 테스트`(board: Board) {
        // given
        val scanner = BoardScanner(board)
        val putStone = Stone.Black
        val putPosition = Scala(3, 5)

        board.printBoard()

        // when
        val scan: ScanContainer = scanner.scan(putStone, putPosition)

        // then
        scan[Direction.N][0].let {
            assertThat(it.count).isEqualTo(2)
            assertThat(it.state).isEqualTo(MoveState.SAME)
        }

        scan[Direction.S][0].let {
            assertThat(it.count).isEqualTo(2)
            assertThat(it.state).isEqualTo(MoveState.SAME)
        }

        scan[Direction.E][0].let {
            assertThat(it.count).isEqualTo(1)
            assertThat(it.state).isEqualTo(MoveState.DIFFERENT)
        }

        scan[Direction.W][0].let {
            assertThat(it.count).isEqualTo(1)
            assertThat(it.state).isEqualTo(MoveState.SAME)
        }
    }
}
