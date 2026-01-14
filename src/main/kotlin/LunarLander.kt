/*
 * Author: Zev Thompson
 *
 * Collaboration Statement: Worked on/finished it in the same room as Ian, discussed code but didn't ever look at each others' code
 */

import java.util.Scanner

class LunarLander(var altitude: Int=1000, var velocity: Int=40, var fuel: Int=25){
    fun burn(fuel_requested: Int){
        if(fuel>=fuel_requested){
            fuel -= fuel_requested
            velocity -= 4*fuel_requested
            velocity += 2
            altitude = altitude - velocity
        }
        else{fuel -= fuel}
    }
    fun status(): String{
        return when{
            altitude>0 -> "inflight"
            altitude<=0 && velocity >=5 -> "crashed"
            else -> "landed"
        }
    }
}


fun main() {
    val lunar: LunarLander = LunarLander()
    println(" ---- ----\nLunar Lander, now!")
    while(lunar.status()=="inflight"){
        println(" --")
        println("Alt: ${lunar.altitude}, Velo: ${lunar.velocity}, Fuel: ${lunar.fuel}")
        print("How much fuel to burn?: ")
        lunar.burn(readln().toInt())
    }
    println("--")
    when(lunar.status()){
        "crashed" -> println("You crashed. :( Dummy")
        "landed" -> println("You landed!")
        else -> println("Something bizarre happened.. replay the game!")
    }
}

// Reflection: No particular issues I ran into, just often forgetting &
//             remembering syntax for stuff like -= and returns. I think
//             I spent like 45 minutes coding this project.
