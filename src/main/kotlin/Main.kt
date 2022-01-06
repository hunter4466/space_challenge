package design

import simulation.Simulation

fun main(args: Array<String>) {
    buildItem()
}

fun buildItem() {
    val item = Item("Solar Panels", 1000)
    val item2 = Item("Solar Panels", 9000)
    val item3 = Item("Solar Panels", 9000)
    val item4 = Item("Solar Panels", 1000)
    val item5 = Item("Solar Panels", 1000)
    val rocket = U1()
    rocket.loadItem(item)
    rocket.loadItem(item2)
    rocket.loadItem(item3)
    rocket.loadItem(item4)
    rocket.loadItem(item5)
    println(rocket.payLoad)
}