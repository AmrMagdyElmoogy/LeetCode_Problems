class Solution {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val distinctSize = nums.toSet().size
        var ans = 0
        for (i in 0 until nums.size) {
            val temp = mutableSetOf(nums[i])
            for (j in i until nums.size) {
                temp.add(nums[j])
                if(temp.size == distinctSize){
                    ans++
                }
            }
        }
        return ans
    }
}