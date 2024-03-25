class RecentCounter() {
    private val hash = TreeMap<Int, Int>()
    private var pnt = 1
    fun ping(t: Int): Int {
        hash[t] = pnt++
        val range = Pair(t - 3000, t)
        val first = hash[range.first] ?: closestLargeNumber(range.first)
        val second = hash[range.second]!!
        return second - first + 1
    }

    private fun closestLargeNumber(first: Int) = hash[hash.keys.first { it > first }]!!
}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */