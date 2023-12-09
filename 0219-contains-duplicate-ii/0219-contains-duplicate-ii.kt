class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val m = mutableMapOf<Int, Int>()
            val range = 0..k
            for (i in range) {
                if(i<nums.size){
                    m[nums[i]] = m.getOrDefault(nums[i], 0) + 1
                    if (m[nums[i]]!! > 1)
                        return true 
                }

            }
            for (i in k + 1 until nums.size) {
                m[nums[i]] = m.getOrDefault(nums[i], 0) + 1
                m[nums[i - k- 1]] = m[nums[i-k-1]]!! - 1
                if (m[nums[i]]!! > 1)
                    return true
            }
            return false
    }
}