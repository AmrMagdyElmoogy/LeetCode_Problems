class Solution {
       fun findAnagrams(s: String, p: String): List<Int> {
            var left = 0
            val result = mutableListOf<Int>()
            val pCount = mutableMapOf<Char, Int>()
            val sCount = mutableMapOf<Char, Int>()
            val sSize = s.length
            for (i in p) {
                pCount[i] = pCount.getOrDefault(i, 0) + 1
            }
            val windowSize = p.length
            for (i in 0 until sSize) {
                sCount[s[i]] = sCount.getOrDefault(s[i], 0) + 1
                if (i - left + 1 > windowSize) {
                    sCount[s[left]] = sCount[s[left]]!! - 1
                    if(sCount[s[left]] == 0)
                        sCount.remove(s[left])
                    left++
                }  
                if (i - left + 1 == windowSize) {
                    var count = 0
                    sCount.forEach { key, value ->
                        if (pCount.containsKey(key) && value == pCount[key])
                            count+= value
                    }
                    if (count == windowSize)
                        result.add(left)
                }
            }
            return result
    }

}