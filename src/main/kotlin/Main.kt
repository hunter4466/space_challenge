package design
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    buildItem()
}

fun buildItem() {
    val item = Item("Solar Panels", 1000)
    println("${item.name} ${item.weight}")
}