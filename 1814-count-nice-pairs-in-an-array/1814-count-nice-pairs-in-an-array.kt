class Solution {
     fun countNicePairs(nums: IntArray): Int {
            val m = mutableMapOf<Int, Long>()
            var result = 0L
            nums.forEach {
                val reversedInteger = it.toString().reversed().toInt()
                val key = it - reversedInteger
                m[key] = m.getOrDefault(key, 0) + 1
            }

            m.forEach { (key, value) ->
                if (value > 1) {
                    result += value.countPairs()
                }
            }
            return (result % 1000000007).toInt()
      }

        fun Long.countPairs(): Long {
            return (this * (this - 1)) / 2
        }
}