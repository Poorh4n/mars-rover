import main.java.com.marsrover.enums.enums.Direction
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DirectionTest {

    @Test fun `When Facing East left should return North`() {
        Assertions.assertEquals(Direction.NORTH, Direction.EAST.left())
    }

    @Test fun `When Facing East right should return South`() {
        Assertions.assertEquals(Direction.SOUTH, Direction.EAST.right())
    }

    @Test fun `When Facing North left should return West`() {
        Assertions.assertEquals(Direction.WEST, Direction.NORTH.left())
    }

    @Test fun `When Facing North right should return East`() {
        Assertions.assertEquals(Direction.EAST, Direction.NORTH.right())
    }

    @Test fun `When Facing West left should return South`() {
        Assertions.assertEquals(Direction.SOUTH, Direction.WEST.left())
    }

    @Test fun `When Facing West right should return North`() {
        Assertions.assertEquals(Direction.NORTH, Direction.WEST.right())
    }

    @Test fun `When Facing South left should return East`() {
        Assertions.assertEquals(Direction.EAST, Direction.SOUTH.left())
    }

    @Test fun `When Facing South right should return West`() {
        Assertions.assertEquals(Direction.WEST, Direction.SOUTH.right())
    }

}