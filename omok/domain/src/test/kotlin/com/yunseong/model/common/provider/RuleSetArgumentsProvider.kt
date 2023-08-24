package com.yunseong.model.common.provider

import com.yunseong.model.board.printer.PrettyPrinter
import com.yunseong.model.board.printer.SimplePrinter
import com.yunseong.model.common.provider.BoardUtils.createBoard
import com.yunseong.model.rules.RuleSet
import com.yunseong.model.scan.BoardScanner
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.AnnotationConsumer
import java.util.stream.Stream
import kotlin.reflect.full.createInstance

class RuleSetArgumentsProvider : ArgumentsProvider, AnnotationConsumer<RuleTest> {

    private lateinit var ruleSet: RuleSet

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(ruleSet)
        )
    }

    override fun accept(t: RuleTest) {
        val board = createBoard(t.board)
        val scanner = BoardScanner(board)
        val ruleSet = RuleSet(scanner)
        val printer = PrettyPrinter()

        t.rules.map {
            it.createInstance()
        }.forEach {
            ruleSet.addRule(it)
        }

        if (t.debug) {
            printer.print(board)
        }

        this.ruleSet = ruleSet
    }
}
