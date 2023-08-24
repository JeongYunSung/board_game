package com.yunseong.model.rules

import com.yunseong.model.scan.ScanContainer

fun interface Rule {

    fun test(container: ScanContainer): RuleResult
}
