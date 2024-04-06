class LUPrefix(n: Int) {
    private val list = MutableList<Int>(n) { 0 }
    private var longest = 0
    fun upload(video: Int) {
        list[video - 1]++
    }

    fun longest(): Int {
        var result = -1
        for (i in longest..<list.size) {
            if (list[i] == 0) {
                result = i
                break
            }
        }
        if (result == -1) {
            longest = list.size
            return longest
        }
        longest = if (result == 0)
            0
        else
            result - 1
        return result
    }

}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * var obj = LUPrefix(n)
 * obj.upload(video)
 * var param_2 = obj.longest()
 */