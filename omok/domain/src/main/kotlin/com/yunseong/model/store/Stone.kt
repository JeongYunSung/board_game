package com.yunseong.model.store

sealed interface Stone {

    fun isStone(): Boolean

    data object Empty : Stone {
        override fun isStone(): Boolean = false

        override fun toString(): String = "E"
    }

    data object Black : Stone {
        override fun isStone(): Boolean = true

        override fun toString(): String = "B"
    }

    data object White : Stone {
        override fun isStone(): Boolean = true

        override fun toString(): String = "W"
    }

    companion object {

        fun from(value: String): Stone {
            return when (value.lowercase()) {
                "empty" -> Empty
                "black" -> Black
                "white" -> White
                else -> throw IllegalArgumentException("value is not Stone")
            }
        }
    }
}
