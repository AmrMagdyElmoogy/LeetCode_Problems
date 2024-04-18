class CombinationIterator(characters: String, combinationLength: Int) {
    private var allCombinations: MutableList<String>
    private var index = 0

    init {
        allCombinations = generateCombination(characters, combinationLength)
    }

    private fun generateCombination(characters: String, combinationLength: Int): MutableList<String> {
        val result = mutableListOf<String>()
        generateCombinationHelper(characters, combinationLength, 0, StringBuilder(), result)
        return result
    }

    private fun generateCombinationHelper(
        characters: String,
        combinationLength: Int,
        start: Int,
        st: StringBuilder,
        result: MutableList<String>
    ) {
        if (st.length == combinationLength) {
            result.add(st.toString())
            return
        }

        for (i in start..<characters.length) {
            st.append(characters[i])
            generateCombinationHelper(characters, combinationLength, i + 1, st, result)
            st.deleteCharAt(st.length - 1)
        }
    }

    fun next(): String {
        return allCombinations[index++]
    }

    fun hasNext(): Boolean {
        return index < allCombinations.size
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */