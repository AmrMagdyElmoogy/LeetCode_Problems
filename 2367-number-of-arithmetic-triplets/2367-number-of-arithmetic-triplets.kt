class Solution {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val m = mutableMapOf<Int,Int>()
        var cnt = 0
        val size = nums.size
        for(i in 0 until size){
            m[nums[i]] = 1
        }
        
        for(i in 0 until size){
            val secondKey = nums[i] + diff 
            val thirdKey = secondKey + diff
            if(m.containsKey(secondKey) && m.containsKey(thirdKey))
            {
                cnt++
            }
        }
        return cnt
    }
}