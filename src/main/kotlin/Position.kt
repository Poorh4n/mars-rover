package main.java.com.marsrover.enums

import main.java.com.marsrover.enums.enums.Direction

class Position(val x :Int, val y: Int, val direction: Direction) {

    fun rotateLeft(): Position = Position(x, y, direction.left())

    fun rotateRight(): Position = Position(x, y, direction.right())

    fun moveAhead(): Position {
        return when(direction) {
            Direction.EAST -> Position(x + 1, y, direction)
            Direction.WEST -> Position(x - 1, y, direction)
            Direction.NORTH -> Position(x, y + 1, direction)
            Direction.SOUTH -> Position(x, y - 1, direction)
        }
    }

    fun isInTheRange( xCoor : Int,  yCoor : Int): Boolean =  x <= xCoor && y <= yCoor && x >= 0 && y >= 0

    override fun toString(): String {
        return x.toString() + " " + y.toString() + " " + direction.direction
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position
        return x == other.x && y == other.y
    }

}