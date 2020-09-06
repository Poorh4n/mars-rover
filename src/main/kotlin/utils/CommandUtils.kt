package main.java.com.marsrover.enums.utils

import java.lang.Exception
import java.util.stream.Collectors

object CommandUtils {

    fun isValidCommandInput(commandInput:String) : String? {
        return try {
            if(commandInput.chars().mapToObj { c -> c.toChar() }.collect(Collectors.toList()).none { c -> !(c == 'L' || c == 'M' || c == 'R')}) {
                commandInput
            } else {
                println("Command Inputs are not valid. Please use upperCase valid letters. Valid Letters are M L R. EX: MMLRMMLR")
                null
            }
        } catch (e:Exception) {
            println("Command Inputs are not valid. Please use upperCase valid letters. Valid Letters are M L R. EX: MMLRMMLR")
            null
        }

    }
}