class KthLargest(val k: Int, nums: IntArray) {

    private val queue = PriorityQueue<Int>()

    init {
        nums.forEach {
            queue.offer(it)
        }
        while (queue.size > k) {
            queue.poll()
        }
    }

    fun add(`val`: Int): Int {
        queue.offer(`val`)
        while (queue.size > k)
            queue.poll()
        return queue.peek()
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */