class Solution {
    fun decodeMessage(key: String, message: String): String {
        var a = 'a'
        var result = ""
        val m = mutableMapOf<Char,Char>()
        for(i in key)
        {
            if(i!= ' ')
            {
                if(!m.containsKey(i)){
                    m[i] = a
                    a++
                }
            }

        }
        for(i in message){
            result += if(i!=' ') {
                m[i]
            } else {
                ' '
            }

        }
        return result
    }
}