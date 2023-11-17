class Solution {
    fun minPairSum(nums: IntArray): Int {
        var result = Integer.MIN_VALUE
        nums.sort()
        var i = 0
        var j = nums.size-1 
        while(i<j){
            val sum = nums[i] + nums[j]
            result = maxOf(result,sum)
            i++
            j--
        } 
        return result
    }
}