import main.java.com.marsrover.enums.utils.CommandUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CommandUtilsTest {

    @Test fun `Should return command String when all commands is upper case letters`() {
        Assertions.assertEquals("L", CommandUtils.isValidCommandInput("L"))
        Assertions.assertEquals("MRMLMMR", CommandUtils.isValidCommandInput("MRMLMMR"))
    }

    @Test fun `Should return null String when all commands is not upper case letters`() {
        Assertions.assertNull(CommandUtils.isValidCommandInput("AA"))
        Assertions.assertNull(CommandUtils.isValidCommandInput("mlr"))
        Assertions.assertNull(CommandUtils.isValidCommandInput("123"))
        Assertions.assertNull(CommandUtils.isValidCommandInput("L M L"))
    }
}