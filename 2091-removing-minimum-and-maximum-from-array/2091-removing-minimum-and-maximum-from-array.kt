class Solution {
    fun minimumDeletions(nums: IntArray): Int {
        if (nums.size == 1)
            return 1
        var (indexOfMinimum, indexOfMaximum) = 0 to 0
        var (minimum, maximum) = Integer.MAX_VALUE to Integer.MIN_VALUE
        val n = nums.size
        for (i in 0 until n) {
            if (nums[i] > maximum) {
                maximum = nums[i]
                indexOfMaximum = i
            }
            if (nums[i] < minimum) {
                minimum = nums[i]
                indexOfMinimum = i
            }
        }

        val firstFront = indexOfMinimum + 1
        val firstBack = n - indexOfMinimum
        val secondFront = indexOfMaximum + 1
        val secondBack = n - indexOfMaximum

    val result =
        listOf(
            maxOf(firstFront, secondFront),
            maxOf(firstBack, secondBack),
            secondBack + firstFront,
            secondFront + firstBack
        )
        return result.min()
    }
}