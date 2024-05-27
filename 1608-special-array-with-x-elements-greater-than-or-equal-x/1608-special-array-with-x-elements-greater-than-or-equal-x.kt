class Solution {
    fun specialArray(nums: IntArray): Int {
        var result = -1
        nums.forEach {
            result = max(result, it)
        }

        (0..result).forEach { number ->
            if (nums.count { it >= number } == number) {
                return number
            }
        }
        return -1
    }
}