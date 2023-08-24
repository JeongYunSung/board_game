package com.yunseong.model.rules

import com.yunseong.model.position.Scala
import com.yunseong.model.scan.BoardScanner
import com.yunseong.model.stone.Stone

data class RuleSet(
    val boardScanner: BoardScanner,
    val rules: MutableList<Rule> = mutableListOf()
) {

    fun test(stone: Stone, scala: Scala) {
        for (rule in rules) {
            if(rule.test(boardScanner.scan(stone, scala)) == RuleResult.DENY) {
                throw IllegalStateException("금수입니다.")
            }
        }
    }

    fun addRule(rule: Rule) {
        rules.add(rule)
    }

    operator fun set(index: Int, rule: Rule) {
        rules[index] = rule
    }

    operator fun get(index: Int): Rule {
        return rules[index]
    }
}