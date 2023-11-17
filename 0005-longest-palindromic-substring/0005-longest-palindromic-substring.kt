class Solution {
    fun longestPalindrome(s: String): String {
        val size = s.length
        var result = ""
        for (i in 0 until size) {
            for (j in size - 1 downTo i) {
                val str = s.substring(i, j + 1)
                if (isPalindromic(str)) {
                    if (result.length < str.length)
                        result = str
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