class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
            val rows = mat.size
            val cols = mat[0].size
            val m = mutableMapOf<Int, MutableList<Int>>()

            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    val diagonalIndex = i - j
                    m.computeIfAbsent(diagonalIndex) { mutableListOf() }.add(mat[i][j])
                }
            }

            m.forEach {
                it.value.sort()
            }

            val result = Array(rows) { IntArray(cols) }

            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    val diagonalIndex = i - j
                    result[i][j] = m[diagonalIndex]!!.first()
                    m[diagonalIndex]!!.removeAt(0)
                }
            } 
            return result
    }

}