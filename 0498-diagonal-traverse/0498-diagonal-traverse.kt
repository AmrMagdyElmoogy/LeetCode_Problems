class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mutableMapOf<Int,MutableList<Int>>()
        val size = mat.size
        for(i in size-1 downTo 0){
            for(j in 0 until mat[i].size){
                m.computeIfAbsent(i+j){mutableListOf<Int>()}.add(mat[i][j])             
            }
        } 
        var curr = 0
        val isEven: (Int)-> Boolean = { it%2==0 }
        var sizeOfMap = m.size-1
        val list = mutableListOf<Int>()
        while(sizeOfMap >=0){
            if(!isEven(curr))
            {
                val reversedList = m[curr]!!.reversed().toMutableList()
                list.addAll(reversedList)
            }
            else {
                list.addAll(m[curr]!!)
            }
            curr++
            sizeOfMap--
        } 
        return list.toIntArray()
    }
}