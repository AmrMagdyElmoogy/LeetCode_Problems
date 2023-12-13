class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val m = hashMapOf<Int,Int>()
        var (left,sum) = 0 to 0
        var maximum = 0
        val size = nums.size
        for(i in 0 until size)
        {
            m[nums[i]] = m.getOrDefault(nums[i],0)+1
            sum+= nums[i]
            if(m[nums[i]] == 1)
            {
                maximum = maxOf(maximum,sum)
            }
            while(m[nums[i]]!=1){
                sum-= nums[left]
                m[nums[left]] = m[nums[left]]!! -1 
                left++
            }
        }
        return maximum
    }
}