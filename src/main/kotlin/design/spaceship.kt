package design

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(itemWeight: Int, weightLimit: Int, payload: MutableList<Item>): Boolean {
        var count = 0
        for(elm in payload) count += elm.weight!! // TODO: Please avoid using bang bang operators aka YOLO OPERATOR
        return (weightLimit.minus(count)) >= itemWeight
        // TODO: why are you adding default logic to the functions in an interface, this should be overridable in every class
    }
    fun carry(item: Item): Boolean
}

open class Rocket(open val weightLmt: Int) : SpaceShip {
    var payLoad: MutableList<Item> = arrayListOf()
    override fun launch(): Boolean = true // TODO: this a kotlin form to return a simple value in the class
    override fun land(): Boolean {
        return true // TODO: write the returns in kotlin form 
    }
    override fun carry(item: Item): Boolean {
        if (canCarry(item.weight as Int, weightLmt, payLoad)){
            payLoad.add(item)
            return true
        }
        return false
    } // TODO: why does always return true and fals in each case? 
}

class U1(weightLmt: Int = 8000) : Rocket(weightLmt) {
    val rocketCost: Int = 100000000 // TODO: for future cases please use Companion object to define constants
    val rocketWeight: Int = 10000 // TODO: as far I see, this variable is not in use
    val launchExplodeChance: Int = 5 // TODO: This functions could be private
    val landingCrashChance: Int = 1

    //TODO: if you are using and interface with a default behavior, why are you overriding the default behavior.
    override fun launch(): Boolean {
        var cargo: Int = 0
        for (elm in payLoad) cargo += elm.weight!!
        val newChance: Int = launchExplodeChance * (cargo / weightLmt)
        if ((1..100).random() in 0..newChance) return false
        return true
    }
    // TODO: Why are you duplicating the same logic as the function above?
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
    val rocketWeight: Int = 18000 //TODO: again a function not in us
    val launchExplodeChance: Int = 4 //TODO:  same comments as classes at top of file
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
