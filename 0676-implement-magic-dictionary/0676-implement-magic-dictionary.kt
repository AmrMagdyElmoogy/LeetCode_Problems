class MagicDictionary() {
    private var dict = arrayOf<String>()

    fun buildDict(dictionary: Array<String>) {
        dict = dictionary
    }

    fun search(searchWord: String): Boolean {
        dict.forEach {
            if (areSameSize(it, searchWord)) {
                if(isThereOneCharacterDifference(it, searchWord))
                    return true
            }
        }
        return false
    }

    private fun areSameSize(str1: String, str2: String) = str1.length == str2.length
    private fun isThereOneCharacterDifference(str1: String, str2: String): Boolean {
        var cnt = 0
        for (i in 0 until str1.length) {
            if (str1[i] != str2[i])
                cnt++
            if (cnt > 1)
                return false
        }
        return cnt == 1 
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */