package com.yunseong.model.common.provider

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(BoardArgumentsProvider::class)
@ParameterizedTest
annotation class BoardTest(
    val value: Array<String> = [],
    val size: Int = 4,
    val delimiter: String = ","
)
