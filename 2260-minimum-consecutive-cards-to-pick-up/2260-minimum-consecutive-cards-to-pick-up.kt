class Solution {
       fun minimumCardPickup(cards: IntArray): Int {
        var ans = Integer.MAX_VALUE
        var flag = false
        val m = mutableMapOf<Int, MutableList<Int>>()
        for(i in 0 until cards.size) {
            m.computeIfAbsent(cards[i]) { mutableListOf() }.add(i)
        }
        for (i in m.values) {
            if (i.size >= 2) {
                flag = true
                for (j in 1 until i.size) {
                    ans = minOf(ans, abs(i[j] - i[j - 1])+1)
                }
            }
        }
        return if(!flag) -1 else ans
    }
}