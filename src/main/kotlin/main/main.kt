package design.simulation.main

import design.simulation.Simulation

class Main {
    val simulation1 = Simulation("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d67_phase-1/phase-1.txt")
    val simulation2 = Simulation("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d88_phase-2/phase-2.txt")
    fun runSimulations(){
        println("Results of Phase one:")
        simulation1.runSimulation()
        println("Results of Phase two:")
        simulation2.runSimulation()
    }
}