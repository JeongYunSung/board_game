package com.yunseong.model.position

enum class Direction(val x: Int, val y: Int) {
    E(1, 0),
    W(-1, 0),
    S(0, 1),
    N(0, -1),
    SE(1, 1),
    SW(-1, 1),
    NE(1, -1),
    NW(-1, -1);

    companion object {

        val N_VEC: Vector = Vector(Scala(1, 1), N)
        val S_VEC: Vector = Vector(Scala(1, 1), S)
        val E_VEC: Vector = Vector(Scala(1, 1), E)
        val W_VEC: Vector = Vector(Scala(1, 1), W)
        val NE_VEC: Vector = Vector(Scala(1, 1), NE)
        val NW_VEC: Vector = Vector(Scala(1, 1), NW)
        val SE_VEC: Vector = Vector(Scala(1, 1), SE)
        val SW_VEC: Vector = Vector(Scala(1, 1), SW)

        val line = listOf(
            E to W,
            N to S,
            SE to NW, 
            SW to NE
        )
    }

    fun toVector(): Vector =
        when (this) {
            E -> E_VEC
            W -> W_VEC
            S -> S_VEC
            N -> N_VEC
            SE -> SE_VEC
            SW -> SW_VEC
            NE -> NE_VEC
            NW -> NW_VEC
        }
}
