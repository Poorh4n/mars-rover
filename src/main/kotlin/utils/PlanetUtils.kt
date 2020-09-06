package main.java.com.marsrover.enums.utils

import main.java.com.marsrover.enums.Position

object PlanetUtils {
    fun isThereAnObstacleOnTheWay(obstacles: ArrayList<Position>, position: Position) : Boolean {
        return obstacles.isNotEmpty() && obstacles.any { obs -> obs.equals(position) }

    }
}