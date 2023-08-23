package com.yunseong.model.scan

import com.yunseong.model.position.Direction

data class ScanContainer(
    private val data: Map<Direction, Road>
) {

    operator fun get(direction: Direction): Road {
        return data[direction] ?: throw IllegalArgumentException("Direction is not valid")
    }
}
