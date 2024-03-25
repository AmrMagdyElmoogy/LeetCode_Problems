class OrderedStream(n: Int) {

    private val list = MutableList(n) { "" }
    private var pnt = 0
    fun insert(idKey: Int, value: String): List<String> {
        list[idKey - 1] = value
        val result = mutableListOf<String>()
        if(idKey-1 == pnt){
            while(pnt < list.size && list[pnt]!= "")
            {
                result.add(list[pnt])
                pnt++
            }
        }
        return result
    }

}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */