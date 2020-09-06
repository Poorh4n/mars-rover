import main.java.com.marsrover.enums.Position
import main.java.com.marsrover.enums.enums.Direction
import main.java.com.marsrover.enums.utils.PlanetUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

class PlanetUtilsTest {

    @Test fun `Should return false if there is an not obstacle` () {
        var obstacles = ArrayList<Position>()
        var position = Position(2,3, Direction.NORTH)

        obstacles.add(Position(2,2, Direction.EAST))
        Assertions.assertFalse(PlanetUtils.isThereAnObstacleOnTheWay(obstacles, position))
    }

    @Test fun `Should return true if there is an obstacle` () {
        var obstacles = ArrayList<Position>()
        var position = Position(2,3, Direction.NORTH)

        obstacles.add(Position(2,3, Direction.EAST))
        Assertions.assertTrue(PlanetUtils.isThereAnObstacleOnTheWay(obstacles, position))
    }

}