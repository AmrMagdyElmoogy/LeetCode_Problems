class Solution {
    fun removeStars(s: String): String {
        val size = s.length
        var starCount = 0
        val result = StringBuilder()
        for(i in size-1 downTo 0){
            if(s[i] == '*')
                starCount++
            else if(starCount>0){
                starCount--
                continue
            }
            else {
                result.append(s[i])
            }
        }
        return result.reversed().toString()
    }
}