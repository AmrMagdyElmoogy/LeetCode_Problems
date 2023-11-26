class Solution {
    fun sortVowels(s: String): String {
             val isVowel: (Char) -> Boolean = {
            it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
                    || it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U'
        }
        val str = s.filter { isVowel(it) }.toMutableList().sorted()
        val vowels = StringBuffer()
        str.forEach {
            vowels.append(it)
        }
        val result = StringBuffer(s)
        var i = 0
        s.forEachIndexed { j, it ->
            if (isVowel(it)) {
                result.setCharAt(j, vowels[i])
                if (i < vowels.length-1) {
                    i++
                }
            }
        }
        return result.toString()
    }
}