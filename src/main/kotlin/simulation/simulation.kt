package design.simulation
import design.Item
import design.Rocket
import design.U1
import java.net.HttpURLConnection
import java.net.URL

class Simulation(private val url: String) {
    fun loadItems(): ArrayList<Item> {
        var itemsCollection: ArrayList<Item> = arrayListOf()
        val conn = URL(url).openConnection() as HttpURLConnection
        val responseBody = conn.inputStream.use { it.readBytes() }.toString(Charsets.UTF_8)
        responseBody.reader().forEachLine {
            val arr = it.split("=")
            itemsCollection.add(Item(arr[0], arr[1] as Int))
        }
        return itemsCollection
    }
    fun loadU1(u1Rockets: ArrayList<U1> = arrayListOf()) {
        val items: ArrayList<Item> = loadItems()
        val rockets: ArrayList<U1> = arrayListOf()
        fun fillRocket() {
            val rocket: U1 = U1()
            for(elm in items) {
                if(rocket.carry(elm)) items.remove(elm)
            }
            rockets.add(rocket)
            if (items.size > 0) fillRocket()
        }
    }

}