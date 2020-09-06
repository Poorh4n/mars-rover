package main.java.com.marsrover.enums

import main.java.com.marsrover.enums.utils.PlanetUtils
import java.lang.Exception
import java.lang.NumberFormatException

class Planet(var x: Int, var y: Int) {

    var roversInthePlanet = ArrayList<Position>()

    fun isValidMove(position: Position): Boolean {
        return position.isInTheRange(x, y) && !PlanetUtils.isThereAnObstacleOnTheWay(roversInthePlanet, position)
    }

    companion object {
        fun createPlanet(planetString: String) : Planet? {
            val coordinates: Array<String> = planetString.split(" ").toTypedArray()
            return try {
                Planet(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]))
            } catch (e : Exception) {
                println("You entered Planet Input wrong. Please try again. Format Ex: 5 5")
                null
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Planet
        return x == other.x && y == other.y
    }
}