class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {

        val comparator = Comparator<Int> { item1, item2 -> item2.compareTo(item1) }
        val queue = PriorityQueue(comparator)
        happiness.forEach {
            queue.offer(it)
        }

        var sum = 0L
        var turn = 0
        var iterations = k

        while (iterations > 0) {
            val happinessOfStudent = queue.poll() - turn
            if (happinessOfStudent > 0)
                sum += happinessOfStudent
            else
                break
            turn++
            iterations--
        }
        
        return sum
    }
}