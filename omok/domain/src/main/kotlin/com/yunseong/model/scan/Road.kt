package com.yunseong.model.scan

class Road(
    private val footPrints: MutableList<FootPrint> = mutableListOf()
) : Iterable<FootPrint> {
    fun size(): Int {
        return footPrints.size
    }

    fun totalCount(): Int {
        return footPrints.sumOf { it.count }
    }

    fun add(footPrint: FootPrint) {
        footPrints.add(footPrint)
    }

    fun isNotEmpty(): Boolean {
        return footPrints.isNotEmpty()
    }

    operator fun get(index: Int): FootPrint {
        return footPrints[index]
    }

    operator fun set(index: Int, footPrint: FootPrint) {
        footPrints[index] = footPrint
    }

    override fun iterator(): Iterator<FootPrint> {
        return object : Iterator<FootPrint> {
            private var currentCount = 0
            private var currentIndex = 0
            private var currentNode: FootPrint = footPrints[currentIndex++]

            override fun hasNext(): Boolean {
                return currentIndex < footPrints.size
            }

            override fun next(): FootPrint {
                if (currentCount >= currentNode!!.count) {
                    currentCount = 0
                    currentNode = footPrints[currentIndex++]
                }
                currentCount++

                return currentNode!!
            }
        }
    }
}
