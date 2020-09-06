package main.java.com.marsrover.enums.enums

import java.lang.IllegalStateException

enum class Direction(val direction: String) {

    NORTH("N") {
        override fun left() = WEST
        override fun right() = EAST
    },
    WEST("W") {
        override fun left() = SOUTH
        override fun right() = NORTH
    },
    SOUTH("S") {
        override fun left() = EAST
        override fun right() = WEST
    },
    EAST("E") {
        override fun left() = NORTH
        override fun right() = SOUTH
    };

    abstract fun left(): Direction
    abstract fun right(): Direction

    companion object {
        fun get(direction: String) : Direction {
            return when(direction) {
                "E" -> EAST
                "N" -> NORTH
                "S" -> SOUTH
                "W" -> WEST
                else -> throw  IllegalStateException("Unkown Direction")
            }
        }
    }
}