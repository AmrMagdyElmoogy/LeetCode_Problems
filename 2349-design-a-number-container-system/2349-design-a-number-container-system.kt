class NumberContainers {
    private val numberMap = mutableMapOf<Int, Int>()
    private val smallestIndexMap = mutableMapOf<Int, Int>()

    fun change(index: Int, number: Int) {
        val previousNumber = numberMap[index]
        numberMap[index] = number

        if (previousNumber != null) {
           if (smallestIndexMap[previousNumber] == index) {
                val minIndex = numberMap.filterValues { it == previousNumber }.keys.minOrNull()
                smallestIndexMap[previousNumber] = minIndex ?: Int.MAX_VALUE
            }
        }

        smallestIndexMap[number] = minOf(smallestIndexMap.getOrDefault(number, Int.MAX_VALUE), index)
    }

    fun find(number: Int): Int {
        var value = smallestIndexMap.getOrDefault(number, -1)
        if(value == Int.MAX_VALUE)
            value  = -1
        return value
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */