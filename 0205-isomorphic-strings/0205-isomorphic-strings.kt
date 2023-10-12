class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val m = mutableMapOf<Char,Char>()
        var result = ""
        for(i in s.length-1 downTo 0){
            if(!m.contains(s[i])){
                if(result.contains(t[i]))
                {
                    break
                }
                else 
                {
                    result+= t[i]
                    m[s[i]] = t[i]
                }
                
            }
            else 
            {
                result+= m[s[i]]
            }
        } 
        result = result.reversed()
        if(result == t)
        {
            return true
        }
        return false
    }
}