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
    val launchExplodeChance: Int = 5
    val landingCrashChance: Int = 1
    override fun launch(): Boolean {
        var cargo: Int = 0
        for (elm in payLoad) cargo += elm.weight!!
        val newChance: Int = launchExplodeChance * (cargo / weightLmt)
        if ((1..100).random() in 0..newChance) return false
        return true
    }
    override fun land(): Boolean {
        var cargo: Int = 0
        for (elm in payLoad) cargo += elm.weight!!
        val newChance: Int = landingCrashChance * (cargo / weightLmt)
        if ((1..100).random() in 0..newChance) return false
        return true
    }
}

class U2(weightLmt: Int = 11000) : Rocket(weightLmt) {
    val rocketCost: Int = 120000000
    val rocketWeight: Int = 18000
    val launchExplodeChance: Int = 4
    val landingCrashChance: Int = 8
    override fun launch(): Boolean {
        var cargo: Int = 0
        for (elm in payLoad) cargo += elm.weight!!
        val newChance: Double = launchExplodeChance * (cargo.toDouble() / weightLmt)
        if ((1..100).random() in 0..newChance.toInt()) return false
        return true
    }
    override fun land(): Boolean {
        var cargo: Int = 0
        for (elm in payLoad) cargo += elm.weight!!
        val newChance: Double = landingCrashChance * (cargo.toDouble() / weightLmt)
        if ((1..100).random() in 0..newChance.toInt()) return false
        return true
    }
}
