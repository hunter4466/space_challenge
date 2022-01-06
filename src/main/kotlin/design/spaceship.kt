package design

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(itemWeight: Int, weightLimit: Int, payload: MutableList<Item>): Boolean {
        var count = 0
        for(elm in payload){
            count += elm.weight!!
        }
        println(count)
        println((weightLimit.plus(count)) > itemWeight)
        return (weightLimit.plus(count)) > itemWeight
    }
    fun carry(item: Item): Boolean
}

open class Rocket(private val weightLmt: Int) : SpaceShip {
    var payLoad: MutableList<Any> = arrayListOf()
    override fun launch(): Boolean {
        return true
    }
    override fun land(): Boolean {
        return true
    }
    override fun carry(item: Item): Boolean {
        payLoad.add(item)
        return true
    }
    fun loadItem(item: Item) {
        if (canCarry(item.weight as Int, weightLmt, payLoad as MutableList<Item>)) {
            carry(item)
        }
    }
}

class U1(weightLmt: Int) : Rocket(weightLmt) {
    val rocketCost: Int = 120000000
    val rocketWeight: Int = 10000
    val maxWeight: Int
    override fun launch(): Boolean {
        return super.launch()
    }

    override fun land(): Boolean {
        return super.land()
    }
}
