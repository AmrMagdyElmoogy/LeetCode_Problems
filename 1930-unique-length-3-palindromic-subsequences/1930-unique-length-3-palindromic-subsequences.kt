class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val st = mutableSetOf<Char>()
        var result = 0
        s.forEach {
            st.add(it)
        }
        st.forEach { letter ->
            var i = -1
            var j = 0
            s.forEachIndexed { k, it ->
                if (it == letter) {
                    if (i == -1)
                        i = k
                    j = k
                }
            }
            val between = mutableSetOf<Char>()
            for (k in i + 1 until j) {
                between.add(s[k])
            }
            result += between.size
        } 
        return result 
    }
}