class Solution {
    fun longestPalindrome(s: String): String {
        val size = s.length
        var result = ""
        val m = mutableMapOf<Char, MutableList<Int>>()
        s.forEachIndexed { i, it ->
            m.computeIfAbsent(it) { mutableListOf() }.add(i)
        }
        m.values.forEach { value ->
        for(i in 0 until value.size){
            for(j in i+1 until value.size){
                val str = s.substring(value[i],value[j]+1)
                if (isPalindromic(str)) {
                    if (result.length < str.length) {
                        result = str
                    }
                }
            }
          }
        }
        if (result.isEmpty())
            return s[0].toString()
        return result
    }

    fun isPalindromic(str: String): Boolean {
        val size = str.length
        var i = 0
        var j = size - 1
        while (i <= j) {
            if (str[i] != str[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}