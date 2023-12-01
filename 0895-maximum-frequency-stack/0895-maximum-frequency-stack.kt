class FreqStack() {
    var index = 0
    val m = mutableMapOf<Int, MutableList<Int>>()
    fun push(`val`: Int) {
        m.computeIfAbsent(`val`) { mutableListOf() }.add(index++)
    }

    fun pop(): Int {
        var maxKey: Int = Int.MIN_VALUE
        var maxValue = mutableListOf<Int>()
        m.forEach { (key, value) ->
            if (maxKey == Int.MIN_VALUE) {
                maxKey = key
                maxValue = value
            } else if (value.size > maxValue.size) {
                maxKey = key
                maxValue = value
            } else if (value.size == maxValue.size) {
                if (value.last() > maxValue.last()) {
                    maxKey = key
                    maxValue = value
                }
            }
        }
        if (m[maxKey]?.isNotEmpty() == true) {
            m[maxKey]?.removeLast()
        }
        return maxKey
    }

}
/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(`val`)
 * var param_2 = obj.pop()
 */