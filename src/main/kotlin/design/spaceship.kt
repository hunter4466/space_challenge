package design

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(itemWeight: Int, weightLimit: Int, payload: MutableList<Item>): Boolean
    fun launchOrLand(chance: Int): Boolean
    fun carry(item: Item): Boolean
}

open class Rocket(open val weightLmt: Int) : SpaceShip {
    var payLoad: MutableList<Item> = arrayListOf()
    override fun canCarry(itemWeight: Int, weightLimit: Int, payload: MutableList<Item>): Boolean {
        var count = 0
        for(elm in payload) count += elm.weight ?: 0
        return (weightLimit.minus(count)) >= itemWeight
    }
    override fun launch(): Boolean = true
    override fun land(): Boolean = true

    override fun carry(item: Item): Boolean {
        if (canCarry(item.weight as Int, weightLmt, payLoad)){
            payLoad.add(item)
            return true
        }
        return false
    }

    override fun launchOrLand(chance: Int): Boolean {
        var cargo = 0
        for (elm in payLoad) cargo += elm.weight ?: 0
        val newChance: Int = chance * (cargo / weightLmt)
        if ((1..100).random() in 0..newChance) return false
        return true
    }
}

class U1() : Rocket(8000) {
    val rocketCost: Int = 100000000
    companion object {
         private const val launchExplodeChance: Int = 5
         private const val landingCrashChance: Int = 1
    }
    override fun launch(): Boolean = launchOrLand(launchExplodeChance)
    override fun land(): Boolean = launchOrLand(landingCrashChance)

}

class U2() : Rocket(11000) {
    val rocketCost: Int = 120000000
    companion object {
        private const val launchExplodeChance: Int = 4
        private const val landingCrashChance: Int = 8
    }
    override fun launch(): Boolean = launchOrLand(launchExplodeChance)
    override fun land(): Boolean = launchOrLand(landingCrashChance)
}
