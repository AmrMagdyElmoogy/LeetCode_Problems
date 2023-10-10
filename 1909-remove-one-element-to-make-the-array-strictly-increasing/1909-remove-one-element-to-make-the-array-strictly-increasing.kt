class Solution {
    fun canBeIncreasing(nums: IntArray): Boolean {
        var count = 0
        for(i in 1 until nums.size)
        {
            if(nums[i-1] >= nums[i])
            {
                count++
                if(i>1 && nums[i-2] >= nums[i])
                {
                    nums[i] = nums[i-1]
                }
            }
            if(count > 2 )
            {
                break
            }
        } 
        if(count < 2)
        return true
        else 
        return false
    }
}