class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
         val m = mutableMapOf<Char,Int>()
         order.forEachIndexed{
             i,it-> m[it] = i+1
         }
         
         for(i in 1 until words.size){
             val first = words[i-1] 
             val second = words[i] 
             var j = 0
             while(j< first.length && j < second.length){
                if(m[first[j]]!! < m[second[j]]!!){
                     break
                 }
                  else if(m[first[j]]!! > m[second[j]]!!)
                 {
                     return false
                 }
                 j++
             }

            if(j == second.length && first.length > second.length)
            {
                return false
            }
             
         }
         return true
        
    }
}