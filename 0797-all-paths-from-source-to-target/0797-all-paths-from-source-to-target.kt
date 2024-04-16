class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        dfs(graph, 0, graph.size - 1, path, result)
        return result
    }

    private fun dfs(
        graph: Array<IntArray>,
        node: Int,
        target: Int,
        path: MutableList<Int>,
        result: MutableList<List<Int>>
    ){
        path.add(node)
        if (node == target)
            result.add(path.toList())
        else
        {
            for (i in graph[node])
                dfs(graph, i, target, path, result)
        }

        path.removeAt(path.size - 1)
    }
}
