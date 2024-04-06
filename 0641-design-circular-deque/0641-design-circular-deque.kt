class MyCircularDeque(k: Int) {
    private val size = k
    private val queue = LinkedList<Int>()
    fun insertFront(value: Int): Boolean {
        if (queue.size < size) {
            queue.addFirst(value)
            return true
        }
        return false
    }

    fun insertLast(value: Int): Boolean {
        if (queue.size < size) {
            queue.addLast(value)
            return true
        }
        return false
    }

    fun deleteFront(): Boolean {
        if (queue.isNotEmpty()) {
            queue.removeFirst()
            return true
        }
        return false
    }

    fun deleteLast(): Boolean {
        if (queue.isNotEmpty()) {
            queue.removeLast()
            return true
        }
        return false
    }

    fun getFront(): Int {
        if (queue.isNotEmpty()) {
            return queue.first
        }
        return -1
    }

    fun getRear(): Int {
        if (queue.isNotEmpty()) {
            return queue.last
        }
        return -1
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun isFull(): Boolean {
        return queue.size == size
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */