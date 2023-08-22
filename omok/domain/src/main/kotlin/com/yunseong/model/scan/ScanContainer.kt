package com.yunseong.model.scan

import com.yunseong.model.position.Direction

data class ScanContainer(
    private val data: Map<Direction, List<FootPrint>>
) {

    operator fun get(direction: Direction): List<FootPrint> {
        return data[direction] ?: throw IllegalArgumentException("Direction is not valid")
    }
}
