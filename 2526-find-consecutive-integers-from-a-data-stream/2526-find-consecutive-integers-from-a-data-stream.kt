import java.util.LinkedList

class DataStream(private val value: Int, private val k: Int) {
    private val window = LinkedList<Int>()

    fun consec(num: Int): Boolean {
        window.offer(num)
        if (window.size > k) {
            window.poll()
        }
        if (window.size == k) {
            for (element in window) {
                if (element != value) {
                    return false
                }
            }
            return true
        }
        return false
    }
}
