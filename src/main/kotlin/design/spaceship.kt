package design

interface SpaceShip {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(itemWeight: Int, weightLimit: Int, payload: Int): Boolean {
        return (weightLimit.plus(payload)) > itemWeight
    }
    fun carry(): Boolean

}

class Rocket : SpaceShip {
    private var payLoad: Array<Int> = arrayOf()
    var item: Any = 80
    var weightLmt: Any = 1000
    override fun launch(): Boolean {
        return true
    }
    override fun land(): Boolean {
        return true
    }
    override fun carry(): Boolean {
        payLoad.add(item)
        return true
    }
    fun loadItem() {
        if (canCarry(item as Int, weightLmt as Int, payLoad as Int)) {

        }
    }

}
