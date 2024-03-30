class CustomStack(maxSize: Int) {

    private val size = maxSize
    private val stack = MutableList(size) { 0 }
    private var cnt = -1

    fun push(x: Int) {
        if (cnt+1 < size) {
            stack[++cnt] = x
        }
    }

    fun pop(): Int {
        if (cnt == -1)
            return -1
        val result = stack[cnt]
        stack[cnt--] = 0
        return result
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0 until k) {
            if (i <= cnt)
                stack[i] += `val`
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */