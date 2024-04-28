class KthLargest(val k: Int, nums: IntArray) {

    private val sortedList = nums.sorted().toMutableList()
    fun add(`val`: Int): Int {
        var flag = false
        run {
            sortedList.forEachIndexed { index, value ->
                if (`val` <= value) {
                    sortedList.add(index, `val`)
                    flag = true
                    return@run
                }
            }
        }
        if (!flag)
            sortedList.add(`val`)
        return sortedList[sortedList.size - k]
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */