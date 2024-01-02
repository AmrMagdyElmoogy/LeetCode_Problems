class SmallestInfiniteSet() {
    private val list = MutableList(1001) { if (it > 0) 1 else 2 }
    fun popSmallest(): Int {
        val index = list.indexOfFirst{it == 1}
        if(index != -1)
            list[index] = 0
        return index
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