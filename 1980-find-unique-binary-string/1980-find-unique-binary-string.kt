class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val m = mutableMapOf<String, Int>()
        val result = StringBuffer("")
        for (i in 0 until nums[0].length)
            result.append("1")
        nums.forEach {
            m[it] = 1
        }
        var i = 0
        while (true) {
            if (!m.containsKey(result.toString())) {
                break
            } else {
                val x = result.get(i)
                if (x == '1')
                    result.setCharAt(i, '0')
                else
                    result.setCharAt(i, '1')
                i++
            }
        }
        return result.toString()
    }
}