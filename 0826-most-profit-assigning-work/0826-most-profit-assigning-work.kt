data class Job(
    val difficulty: Int,
    val profit: Int,
)

class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobs = difficulty.zip(profit).map { Job(it.first, it.second) }.sortedBy { it.difficulty }
        worker.sort()
        var i = 0
        var best = 0
        var result = 0
        val n = difficulty.size
        worker.forEach { skill ->
            while (i < n && skill >= jobs[i].difficulty)
                best = Math.max(best, jobs[i++].profit)
            result += best
        }
        return result
    }
}