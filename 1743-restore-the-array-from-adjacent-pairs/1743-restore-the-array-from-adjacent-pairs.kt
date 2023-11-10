class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val adjacentList = mutableMapOf<Int, MutableList<Int>>()
        adjacentPairs.forEach { pair ->
            adjacentList.computeIfAbsent(pair.first()) { mutableListOf<Int>() }.add(pair.last())
            adjacentList.computeIfAbsent(pair.last()) { mutableListOf<Int>() }.add(pair.first())
        }
        val start = adjacentList.entries.first { it.value.size == 1 }.key

        val result = mutableListOf<Int>()
        dfs(start, adjacentList, mutableSetOf(), result)
        return result.toIntArray()
    }

    fun dfs(
        current: Int,
        adjacentList: MutableMap<Int, MutableList<Int>>,
        visited: MutableSet<Int>,
        result: MutableList<Int>
    ) {
        result.add(current)
        visited.add(current)

        for (neighbour in adjacentList[current] ?: emptyList<Int>()) {
            if (neighbour !in visited) {
                dfs(neighbour, adjacentList, visited, result)
            }
        }
    }
}