class MapSum() {

    private val sumPairs = HashMap<String,Int>()
    fun insert(key: String, `val`: Int) {
        sumPairs[key] = `val`
    }

    fun sum(prefix: String): Int {
        var sum = 0
        sumPairs.keys.forEach {
            if(prefix == it.commonPrefixWith(prefix))
                sum += sumPairs[it]!! 
        }
        return sum 
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */