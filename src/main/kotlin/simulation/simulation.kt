package design.simulation
import design.Item
import design.Rocket
import design.U1
import design.U2
import java.net.HttpURLConnection
import java.net.URL

class Simulation(private val url: String) {
    private fun loadItems(): ArrayList<Item> {
        var itemsCollection: ArrayList<Item> = arrayListOf()
        val conn = URL(url).openConnection() as HttpURLConnection
        val responseBody = conn.inputStream.use { it.readBytes() }.toString(Charsets.UTF_8)
        responseBody.reader().forEachLine {
            val arr = it.split("=")
            itemsCollection.add(Item(arr[0], arr[1].toInt()))
        }
        return itemsCollection
    }
    fun loadU1(): ArrayList<U1> {
        val items: ArrayList<Item> = loadItems()
        val rockets: ArrayList<U1> = arrayListOf()
        fun fillRocket() {
            val rocket = U1()
            for(elm in items) {
                if(rocket.carry(elm)) items.remove(elm)
            }
            rockets.add(rocket)
            if (items.size > 0) fillRocket()
        }
        return rockets
    }
    fun loadU2(): ArrayList<U2> {
        val items: ArrayList<Item> = loadItems()
        val rockets: ArrayList<U2> = arrayListOf()
        fun fillRocket() {
            val rocket = U2()
            for(elm in items) {
                if(rocket.carry(elm)) items.remove(elm)
            }
            rockets.add(rocket)
            if (items.size > 0) fillRocket()
        }
        return rockets
    }
    fun runSimulation(): Int {
        val u1Rockets = loadU1()
        val u2Rockets = loadU2()
        var u1Budget = 0
        var u2Budget = 0
        for(elm in u1Rockets) {
            fun launchRocket(rkt: U1) {
                u1Budget += rkt.rocketCost
                if (!rkt.launch()) launchRocket(rkt)
            }
            launchRocket(elm)
        }
        for(elm in u2Rockets) {
            fun launchRocket(rkt: U2) {
                u2Budget += rkt.rocketCost
                if (!rkt.launch()) launchRocket(rkt)
            }
            launchRocket(elm)
        }
        return u1Budget.plus(u2Budget)
    }
}