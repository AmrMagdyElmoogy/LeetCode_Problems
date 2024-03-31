data class CheckIn(
    val stationName: String,
    val duration: Int,
)

data class CheckOut(
    val stationName: String = "",
    val duration: Int = 0,
)

class UndergroundSystem() {

    private val customersTrips = hashMapOf<Int, Pair<CheckIn, CheckOut>>()
    private val avgStartToEnd = hashMapOf<Pair<String, String>, MutableList<Int>>()
    fun checkIn(id: Int, stationName: String, t: Int) {
        customersTrips[id] = Pair(CheckIn(stationName, t), CheckOut())
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val checkIn = customersTrips[id]!!.first
        customersTrips[id] = Pair(checkIn, CheckOut(stationName, t))
        val pair = avgStartToEnd.getOrPut(Pair(checkIn.stationName, stationName)) { mutableListOf() }
        pair.add(t - checkIn.duration)

    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val pair = Pair(startStation, endStation)
        val list = avgStartToEnd[pair]!!
        return list.average()
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */