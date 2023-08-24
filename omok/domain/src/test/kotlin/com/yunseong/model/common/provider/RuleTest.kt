package com.yunseong.model.common.provider

import com.yunseong.model.rules.Rule
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(RuleSetArgumentsProvider::class)
@ParameterizedTest
annotation class RuleTest(
    val board: BoardTest,
    val rules: Array<KClass<out Rule>>,
    val debug: Boolean = false
)
