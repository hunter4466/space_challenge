package design
fun main(args: Array<String>) {
    buildItem()
}

fun buildItem() {
    val item = Item("Solar Panels", 1000)
    val item2 = Item("Solar Panels", 1000)
    val item3 = Item("Solar Panels", 1000)
    val item4 = Item("Solar Panels", 1000)
    val rocket = Rocket(3000)
    rocket.loadItem(item)
    rocket.loadItem(item2)
    rocket.loadItem(item3)
    rocket.loadItem(item4)
    println(rocket.payLoad)
}