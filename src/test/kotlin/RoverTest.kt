import main.java.com.marsrover.enums.enums.Direction
import main.java.com.marsrover.enums.Planet
import main.java.com.marsrover.enums.Position
import main.java.com.marsrover.enums.Rover
import main.java.com.marsrover.enums.exceptions.IllegalMoveException
import org.junit.jupiter.api.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoverTest {

    lateinit var planet: Planet
    lateinit var rover: Rover

    @BeforeEach
    fun beforeEach() {
        planet = Planet(5, 5)
        rover = Rover(planet, Position(1, 2, Direction.NORTH))
    }

    @Test fun `Rover Should turn right if the command is R`() {
        rover.decodeCommand('R')
        Assertions.assertEquals(Direction.EAST, rover.position.direction)
    }

    @Test fun `Rover Should turn left if the command is L`() {
        rover.decodeCommand('L')
        Assertions.assertEquals(Direction.WEST, rover.position.direction)
    }

    @Test fun `Rover should move when the command is M `() {
        rover.decodeCommand('M')
        Assertions.assertEquals(3, rover.position.y)
    }

    @Test fun `Rover shouldnt move if it is on the edge` () {
        val rover = Rover(planet, Position(5, 2, Direction.NORTH))
        rover.decodeCommand('M')
        Assertions.assertEquals(5, rover.position.x)
    }

    @Test fun `Rover should process command sequence`() {
        rover.processCommands("MMRM");
        Assertions.assertEquals(2, rover.position.x)
        Assertions.assertEquals(4, rover.position.y)
    }

    @Test fun `Rover shouldnt move if there is rover on the way`() {
        planet.roversInthePlanet.add(Position(2,3, Direction.EAST))
        val rover = Rover(planet, Position(2, 2, Direction.NORTH))
        Assertions.assertThrows(IllegalMoveException::class.java) { rover.processCommands("M") }
    }
}