package com.yunseong.model.scan

class Road(
    private val footPrints: MutableList<FootPrint> = mutableListOf()
) : Iterator<FootPrint> {
    private var currentCount = 0
    private var currentIndex = 0
    private var currentNode: FootPrint? = null

    override fun next(): FootPrint {
        check(currentNode != null || hasNext()) {
            "next() should be called after hasNext()"
        }

        if (currentCount >= currentNode!!.count) {
            currentCount = 0
            currentNode = footPrints[currentIndex++]
        }
        currentCount++

        return currentNode!!
    }

    override fun hasNext(): Boolean {
        return currentIndex < footPrints.size
    }

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
}
