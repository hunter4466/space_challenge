package design.simulation
import design.Item
import java.net.HttpURLConnection
import java.net.URL

class Simulation(private val url: String) {
    var itemsCollection: ArrayList<Item> = arrayListOf()
    fun loadItems() {
        val conn = URL(url).openConnection() as HttpURLConnection
        val responseBody = conn.inputStream.use { it.readBytes() }.toString(Charsets.UTF_8)
        responseBody.reader().forEachLine {
            val arr = it.split("=")
            itemsCollection.add(Item(arr[0], arr[1] as Int))
        }
    }

}