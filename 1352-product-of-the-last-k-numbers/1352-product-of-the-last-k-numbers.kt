class ProductOfNumbers() {
    private val list = mutableListOf<Int>()
    fun add(num: Int) {
        list.add(num)

    }

    fun getProduct(k: Int): Int {
        return list.takeLast(k).fold(1) { acc, inc -> acc * inc }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */