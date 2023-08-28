package com.yunseong.model.rules

import com.yunseong.model.common.provider.BoardTest
import com.yunseong.model.common.provider.RuleTest
import com.yunseong.model.position.Scala
import com.yunseong.model.stone.Stone
import org.junit.jupiter.api.assertThrows

class TwinThreeRuleTest {

    @RuleTest(board = BoardTest(
        value = [
            "2,5,black",
            "3,4,black", "3,6,black",
            "4,5,black",
            "6,5,white"
        ],
        size = 10
    ),
        rules = [TwinThreeRule::class],
        debug = true)
    fun `3x3_십자가 테스트(OOO)`(ruleSet: RuleSet) {
        // given
        val putStone = Stone.Black
        val putPosition = Scala(3, 5)

        // when // then
        assertThrows<IllegalStateException> {
            ruleSet.test(putStone, putPosition)
        }
    }

    @RuleTest(board = BoardTest(
        value = [
            "0,5,white",
            "2,5,black",
            "4,4,black", "4,6,black",
            "5,5,black"
        ],
        size = 10,
    ),
        rules = [TwinThreeRule::class],
        debug = true)
    fun `3x3_중간에_공백 테스트(OXOO)`(ruleSet: RuleSet) {
        // given
        val putStone = Stone.Black
        val putPosition = Scala(4, 5)

        // when // then
        assertThrows<IllegalStateException> {
            ruleSet.test(putStone, putPosition)
        }
    }

    @RuleTest(board = BoardTest(
        value = [
            "2,5,black",
            "3,4,black", "3,6,black",
            "5,5,black"
        ],
        size = 10
    ),
        rules = [TwinThreeRule::class])
    fun `3x3_중간에_공백 테스트(OOXO)`(ruleSet: RuleSet) {
        // given
        val putStone = Stone.Black
        val putPosition = Scala(3, 5)

        // when // then
        assertThrows<IllegalStateException> {
            ruleSet.test(putStone, putPosition)
        }
    }

    @RuleTest(board = BoardTest(
        value = [
            "3,4,black", "3,6,black",
            "4,5,black",
            "5,5,black",
            "7,5,white"
        ],
        size = 10
    ),
        rules = [TwinThreeRule::class])
    fun `3x3_한_방향_3개_공백 테스트(XOOO)`(ruleSet: RuleSet) {
        // given
        val putStone = Stone.Black
        val putPosition = Scala(3, 5)

        // when // then
        assertThrows<IllegalStateException> {
            ruleSet.test(putStone, putPosition)
        }
    }
}
