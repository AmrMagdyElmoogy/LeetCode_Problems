class Solution {
   fun specialArray(nums: IntArray): Int {
        val freq = MutableList<Int>(nums.size + 1) { 0 }
        val n = nums.size
        for (i in nums) {
            freq[minOf(n, i)]++
        }

        var numbersGreaterOrEqual = 0

        for (i in freq.size -1 downTo 0) {
            numbersGreaterOrEqual += freq[i]
            if (numbersGreaterOrEqual == i)
                return i
        }
        return -1
    }
}