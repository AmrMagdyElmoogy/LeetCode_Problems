class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val size = nums.size
        val target = nums.sum() - x
        var left = 0
        var windowSum = 0
        var minimumWindow = -1
        for (i in 0 until size) {
            windowSum += nums[i]
            while (windowSum > target && left <= i) {
                windowSum -= nums[left]
                left++
            }
             if (windowSum == target) {
                minimumWindow = maxOf(minimumWindow, i - left + 1)
            }
        }
        if(minimumWindow == -1){
            return -1
        }
        return size - minimumWindow
    }
}