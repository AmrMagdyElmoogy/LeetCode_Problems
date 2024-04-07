class MyHashSet() {
    private val list = MutableList<Int>(1000001) { 0 }
    fun add(key: Int) {
        list[key]++
    }

    fun remove(key: Int) {
        list[key] = 0
    }

    fun contains(key: Int): Boolean {
        return list[key] != 0
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */