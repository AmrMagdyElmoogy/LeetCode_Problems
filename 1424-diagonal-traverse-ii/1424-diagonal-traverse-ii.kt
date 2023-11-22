class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        // we traverse from bottom-left
        val m = mutableMapOf<Int, MutableList<Int>>()
        val size = nums.size
        for (i in size - 1 downTo 0) {
            for (j in 0 until nums[i].size) {
                m.computeIfAbsent(i+j) { mutableListOf() }.add(nums[i][j])
            }
        }
        var curr = 0
        val list = mutableListOf<Int>()
        var sizeOfMap = m.size-1 
        while(sizeOfMap >=0){
            list.addAll(m[curr]!!) 
            curr++
            sizeOfMap--
        }
        return list.toIntArray()
    }
}