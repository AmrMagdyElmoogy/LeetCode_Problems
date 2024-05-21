class Solution {
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var longestAlternatingSubArray = 0

        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                var longestEvenOddSubArray = 0
                if(nums[i]<= threshold)
                    longestEvenOddSubArray++
                for (j in i..<nums.size - 1) {
                    if (isEvenOddPair(nums, j) && nums[j] <= threshold && nums[j + 1] <= threshold) {
                        longestEvenOddSubArray++
                    } else {
                        break
                    }
                }
                longestAlternatingSubArray = max(longestAlternatingSubArray, longestEvenOddSubArray)
            }
        }
        return longestAlternatingSubArray
    }

    private fun isEvenOddPair(nums: IntArray, i: Int) = (nums[i] % 2 == 0 && nums[i + 1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 == 0)
}