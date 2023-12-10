class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var start = 0
        var zeroCount = 0
        var longestSub = 0
        val size = nums.size
        for(i in 0 until size){
            if(nums[i] == 0)
                zeroCount++
            while(zeroCount > 1)
            {
                if(nums[start] == 0)
                    zeroCount--
                start++
            }
            longestSub = maxOf(longestSub, i-start)
        }
        return longestSub 
    }
}