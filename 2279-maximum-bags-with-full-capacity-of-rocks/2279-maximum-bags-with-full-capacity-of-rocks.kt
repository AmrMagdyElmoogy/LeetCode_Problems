class Solution {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
            val result = IntArray(capacity.size) { 0 }
            var max = 0
            for (i in 0 until capacity.size) {
                if (capacity[i] == rocks[i])
                    max++
                result[i] = abs(capacity[i] - rocks[i])
            }
            result.sort()
            var i = 0
            var temp = additionalRocks
            while (temp > 0) {
                if(i==result.size)
                {
                    break
                }
                if(temp>= result[i] && result[i]!=0)
                {
                    temp-= result[i]
                    max++
                }
                i++
            }
            return max 
    }
}