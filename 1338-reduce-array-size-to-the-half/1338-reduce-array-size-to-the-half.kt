class Solution {
    fun minSetSize(arr: IntArray): Int {
        val hash = hashMapOf<Int, Int>()

        arr.forEach {
            var freq = hash.getOrPut(it) { 0 }
            freq++
            hash[it] = freq
        }

        val comparator = Comparator<Pair<Int, Int>> { p1, p2 -> p2.second.compareTo(p1.second) }

        val queue = PriorityQueue(comparator)

        hash.forEach { key, value ->
            queue.offer(Pair(key, value))
        }
        var cnt = 0
        val halfSizeOfArr = arr.size / 2
        var removedArrSize = 0

        while (removedArrSize < halfSizeOfArr && queue.isNotEmpty()) {
            removedArrSize += queue.poll().second
            cnt++
        }
        return cnt
    }
}