class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val (pos, neg) = nums.partition { it >= 0 }
        val result = mutableListOf<Int>()
        for (i in 0..<pos.size) {
            result.add(pos[i])
            result.add(neg[i])
        }
        return result.toIntArray()
    }

}