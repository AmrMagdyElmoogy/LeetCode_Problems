class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.fold("") { acc, i -> acc + i } == word2.fold("") { acc, i -> acc + i }
    }
}