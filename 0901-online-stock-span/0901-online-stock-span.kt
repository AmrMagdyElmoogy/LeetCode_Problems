class StockSpanner() {
    private val list = mutableListOf<Int>()
    fun next(price: Int): Int {
        list.add(price)
        // 100 80 60 70 60 
        val latest = list[list.size-1]
        var cnt = 0
        for(i in 0 until list.size){
            if(list[i] <= latest)
                cnt++
            else
                cnt = 0
        }
        return cnt
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */