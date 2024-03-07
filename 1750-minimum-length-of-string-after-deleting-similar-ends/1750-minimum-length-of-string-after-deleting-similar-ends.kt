class Solution {
    fun minimumLength(s: String): Int {
        var l = 0
        var r = s.length - 1
        while (l < r && s[l] == s[r]) {
            val c = s[l]
            var(count1,count2) = 0 to 0
            while (l <=r && s[l] == c ) {
                l++
            }
            while (r > l && s[r] == c) {
                r--
            }
        }
        return r-l+1
    }
}