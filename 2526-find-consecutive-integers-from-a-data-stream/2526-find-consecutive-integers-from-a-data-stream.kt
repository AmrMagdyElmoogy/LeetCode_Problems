class DataStream(private val value: Int, private val k: Int) {
    private var cnt = 0
    fun consec(num: Int): Boolean {
        if(num == value)
            cnt++
        else 
            cnt = 0
        return cnt>=k
    }
}
