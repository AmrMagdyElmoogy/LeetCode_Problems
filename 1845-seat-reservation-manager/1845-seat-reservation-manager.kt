class SeatManager(n: Int) {

    private val availableSeats = PriorityQueue<Int>()

    init {
        (1..n).forEach {
            availableSeats.offer(it)
        }
    }

    fun reserve(): Int {
        if (availableSeats.isEmpty())
            return -1
        return availableSeats.poll()
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.offer(seatNumber)
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * var obj = SeatManager(n)
 * var param_1 = obj.reserve()
 * obj.unreserve(seatNumber)
 */