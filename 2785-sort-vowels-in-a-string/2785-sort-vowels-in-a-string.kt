class Solution {
    fun sortVowels(s: String): String {
        val setOfVowels = setOf('a', 'e', 'i', 'o', 'u')
        val vowels = s.filter { it.lowercaseChar() in setOfVowels }.toMutableList().sorted()
        var vowelIndex = 0
        val result = StringBuffer(s)
        for (i in 0 until s.length) {
            if (s[i].lowercaseChar() in setOfVowels) {
                result.setCharAt(i, vowels[vowelIndex++])
            }
        }
        return result.toString()
    }
}