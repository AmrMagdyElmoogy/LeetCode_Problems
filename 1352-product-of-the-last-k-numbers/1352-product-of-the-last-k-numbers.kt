class ProductOfNumbers() {
    private var prefixMulti = mutableListOf<Int>(1)
    fun add(num: Int) {
        if (num > 0) {
            prefixMulti.add(prefixMulti.last() * num)
        } else {
            prefixMulti = mutableListOf(1)
        }
    }

    fun getProduct(k: Int): Int {
        val size = prefixMulti.size
        return if (k < size)
            prefixMulti[size - 1] / prefixMulti[size - k - 1]
        else
            0
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */