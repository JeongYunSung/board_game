package com.yunseong.model.position

data class Vector(
    val scala: Scala,
    val direction: Direction
) {

    fun toScala(): Scala {
        return scala
    }

    fun addScala(scala: Scala): Vector {
        return Vector(
            Scala(this.scala.x + (scala.x * this.direction.x), this.scala.y + (scala.y * this.direction.y)),
            this.direction
        )
    }

    fun fromScala(scala: Scala): Vector {
        return Vector(
            Scala(scala.x + (this.scala.x * this.direction.x), scala.y + (this.scala.y * this.direction.y)),
            this.direction
        )
    }
}
