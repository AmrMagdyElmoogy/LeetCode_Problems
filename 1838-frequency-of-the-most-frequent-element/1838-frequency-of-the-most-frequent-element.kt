class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
         nums.sort()
        var maxFreq = 0
        var left = 0
        var curr = 0
        var target = 0

        for (right in 0 until nums.size) {
            target = nums[right]
            curr += nums[right]
            while ((right - left + 1) * target - curr > k) {
                curr -= nums[left]
                left++
            }
            maxFreq = maxOf(maxFreq, (right - left + 1))
        }
        return maxFreq
    }
}