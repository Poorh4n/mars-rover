import main.java.com.marsrover.enums.enums.Direction
import main.java.com.marsrover.enums.Planet
import main.java.com.marsrover.enums.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlanetTest {

    @Test fun `Should return true if a move is valid`() {
        val planet = Planet(5,5)
        Assertions.assertTrue(planet.isValidMove(Position(3,3, Direction.NORTH)))
    }

    @Test fun `Should return false if a move is not valid`() {
        val planet = Planet(5,5)
        Assertions.assertFalse(planet.isValidMove(Position(6,3, Direction.NORTH)))
    }

    @Test fun `Should return planet if char sequence is valid` () {
        Assertions.assertEquals(Planet.createPlanet("5 5"), Planet(5,5))
    }
}