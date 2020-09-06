package main.java.com.marsrover.enums

import main.java.com.marsrover.enums.enums.Direction
import main.java.com.marsrover.enums.exceptions.IllegalMoveException
import java.lang.Exception
import kotlin.jvm.Throws

class Rover(var planet: Planet, var position: Position) {

    @Throws(IllegalMoveException::class)
    private fun move() {
        if(planet.isValidMove(position.moveAhead()))
            position = position.moveAhead()
        else
            throw IllegalMoveException("Cant Move Ahead, there is an obstacle")
    }

    private fun turnLeft() {
        position = position.rotateLeft()
    }

    private fun turnRight() {
        position = position.rotateRight()
    }

    fun processCommands(commandSequence: String) {
        commandSequence.chars().mapToObj { c -> c.toChar() }.forEach(this::decodeCommand)
    }

    fun decodeCommand(command: Char) {
        when(command){
            'R' -> turnRight()
            'L' -> turnLeft()
            'M' -> move()
        }

    }

    companion object {
        fun createRover(planet : Planet, roverPosition : String) : Rover? {
            val position: Array<String> = roverPosition.split(" ").toTypedArray()
            return try {
                Rover(planet, Position(Integer.parseInt(position[0]), Integer.parseInt(position[1]), Direction.get(position[2])))
            } catch (e: Exception) {
                println("You entered Rover Input wrong. Please try again. Format Ex: 1 2 N")
                null
            }

        }
    }
}