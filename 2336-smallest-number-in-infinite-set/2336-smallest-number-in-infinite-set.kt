class SmallestInfiniteSet() {
    private val list = MutableList(1001) { if (it > 0) 1 else 2 }
    fun popSmallest(): Int {
        for (i in 0 until list.size) {
            if (list[i] == 1) {
                list[i] = 0
                return i
            }
        }
        return 0
    }

    fun addBack(num: Int) {
        if (list[num] == 0)
            list[num]++
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */