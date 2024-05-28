class Solution {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        val size = nums.size
        for (i in 1..size) {
            val k = getFirstGreaterOrEqual(nums, i)
            if (size - k == i)
                return i
        }
        return -1
    }

    private fun getFirstGreaterOrEqual(nums: IntArray, i: Int): Int {
        var start = 0
        var end = nums.size - 1
        var index = nums.size
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] >= i) {
                index = mid
                end = mid - 1
            } else
                start = mid + 1
        }

        return index
    }
}