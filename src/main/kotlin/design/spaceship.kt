package design

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(itemWeight: Int, weightLimit: Int, payload: MutableList<Item>): Boolean {
        var count = 0
        for(elm in payload) count += elm.weight!!
        return (weightLimit.minus(count)) >= itemWeight
    }
    fun carry(item: Item): Boolean
}

open class Rocket(open val weightLmt: Int) : SpaceShip {
    var payLoad: MutableList<Item> = arrayListOf()
    override fun launch(): Boolean {
        return true
    }
    override fun land(): Boolean {
        return true
    }
    override fun carry(item: Item): Boolean {
        if (canCarry(item.weight as Int, weightLmt, payLoad)){
            payLoad.add(item)
            return true
        }
        return false
    }
}

class U1(weightLmt: Int = 8000) : Rocket(weightLmt) {
    val rocketCost: Int = 100000000
    val rocketWeight: Int = 10000
    val launchExplChance: Int = 5
    val landingCrshChance: Int = 1
}

class U2(weightLmt: Int = 11000) : Rocket(weightLmt) {
    val rocketCost: Int = 120000000
    val rocketWeight: Int = 18000
    val launchExplChance: Int = 4
    val landingCrshChance: Int = 8
}
