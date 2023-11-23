class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val result = mutableListOf<Boolean>()
        for (i in 0 until l.size) {
            val list = nums.slice(l[i]..r[i]).sorted()
            var diff = 0
            var flag = true
            if (list.size >= 2) {
                diff = list[1] - list[0]
            }
            for (j in 1 until list.size-1) {
                if (list[j + 1] - list[j] != diff) {
                    flag = false
                    break
                }
            }
            if (flag) result.add(true) else result.add(false)
        } 
        return result
    }
}