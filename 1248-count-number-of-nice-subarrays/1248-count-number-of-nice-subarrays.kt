class Solution {
    fun numberOfSubarrays(A: IntArray, k: Int): Int {
        return atMost(A, k) - atMost(A, k - 1)
    }

    fun atMost(A: IntArray, k: Int): Int {
        var k = k
        var res = 0
        var i = 0
        val n = A.size
        for (j in 0 until n) {
            k -= A[j] % 2
            while (k < 0) k += A[i++] % 2
            res += j - i + 1
        }
        return res
    }
}