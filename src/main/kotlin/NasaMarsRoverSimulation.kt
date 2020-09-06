package main.java.com.marsrover.enums

import main.java.com.marsrover.enums.utils.CommandUtils
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    var planet :Planet? = null

    while(planet == null) {
        planet = Planet.createPlanet(reader.nextLine())
    }
    val roverList = ArrayList<Rover>()
    while(reader.hasNext()) {
        var roverPosition = reader.nextLine();
        if(roverPosition == "exit") break;

        var rover :Rover? = null
        while(rover == null) {
            rover = Rover.createRover(planet, roverPosition)
            if(rover == null) roverPosition = reader.nextLine()
        }

        var commandInput :String? = null
        while (commandInput == null) {
            commandInput = CommandUtils.isValidCommandInput(reader.nextLine())
        }
        rover.processCommands(commandInput)
        planet.roversInthePlanet.add(rover.position)
        roverList.add(rover)
    }
    roverList.forEach { r -> println(r.position) }

}
