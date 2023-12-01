class Solution {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        var list = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until score.size) {
            list.add(Pair(score[i][k], i))
        }
        list = list.sortedByDescending { pair -> pair.first }.toMutableList()
        var result = arrayOf<IntArray>()
        for (i in list) {
            val index = i.second
            result += score[index]
        }
        return result
    }
}