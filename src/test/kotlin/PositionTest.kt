import main.java.com.marsrover.enums.enums.Direction
import main.java.com.marsrover.enums.Position
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PositionTest {

    lateinit var positionFacingEast: Position
    lateinit var positionFacingWest: Position
    lateinit var positionFacingNorth: Position
    lateinit var positionFacingSouth: Position

    @BeforeEach
    fun beforeEach() {
        positionFacingEast = Position(2, 3, Direction.EAST)
        positionFacingWest = Position(2, 3, Direction.WEST)
        positionFacingNorth = Position(2, 3, Direction.NORTH)
        positionFacingSouth = Position(2, 3, Direction.SOUTH)
    }

    @Test fun `When facing east rotateLeft should return facing north`() {
        Assertions.assertEquals(Direction.NORTH, positionFacingEast.rotateLeft().direction)
    }

    @Test fun `When facing east rotateRight should return facing south`() {
        Assertions.assertEquals(Direction.SOUTH, positionFacingEast.rotateRight().direction)
    }

    @Test fun `When facing west rotateLeft should return facing south`() {
        Assertions.assertEquals(Direction.SOUTH, positionFacingWest.rotateLeft().direction)
    }

    @Test fun `When facing west rotateRight should return facing north`() {
        Assertions.assertEquals(Direction.NORTH, positionFacingWest.rotateRight().direction)
    }

    @Test fun `When facing north rotateLeft should return facing west`() {
        Assertions.assertEquals(Direction.WEST, positionFacingNorth.rotateLeft().direction)
    }

    @Test fun `When facing north rotateRight should return facing east`() {
        Assertions.assertEquals(Direction.EAST, positionFacingNorth.rotateRight().direction)
    }

    @Test fun `When facing south rotateLeft should return facing east`() {
        Assertions.assertEquals(Direction.EAST, positionFacingSouth.rotateLeft().direction)
    }

    @Test fun `When facing south rotateRight should return facing west`() {
        Assertions.assertEquals(Direction.WEST, positionFacingSouth.rotateRight().direction)
    }

    @Test fun `When facing east move ahead should return + 1 on x coordinate`() {
        Assertions.assertEquals(3, positionFacingEast.moveAhead().x)
    }

    @Test fun `When facing west move ahead should return - 1 on x coordinate`() {
        Assertions.assertEquals(1, positionFacingWest.moveAhead().x)
    }

    @Test fun `When facing north move ahead should return + 1 on y coordinate`() {
        Assertions.assertEquals(4, positionFacingNorth.moveAhead().y)
    }
    @Test fun `When facing south move ahead should return - 1 on y coordinate`() {
        Assertions.assertEquals(2, positionFacingSouth.moveAhead().y)
    }

    @Test fun `Should return true if the given coordinates is in the planet`() {
        val position = Position(1,2, Direction.SOUTH)
        Assertions.assertTrue(position.isInTheRange(5,5))
    }

    @Test fun `Should return false if the given coordinates is not in the planet`() {
        val position = Position(6,2, Direction.SOUTH)
        Assertions.assertFalse(position.isInTheRange(5,5))
    }
}