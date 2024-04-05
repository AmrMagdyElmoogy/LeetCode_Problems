class ThroneInheritance(kingName: String) {
    private val parent = kingName
    private val aliveOrDead = hashMapOf<String, Boolean>(kingName to true)
    private val parentsToChildren = mutableMapOf<String, MutableList<String>>(kingName to mutableListOf())

    fun birth(parentName: String, childName: String) {
        aliveOrDead[parentName] = true
        aliveOrDead[childName] = true
        val children = parentsToChildren.getOrDefault(parentName, mutableListOf())
        children.add(childName)
        parentsToChildren[parentName] = children
    }

    fun death(name: String) {
        aliveOrDead[name] = false
    }

    fun getInheritanceOrder(): List<String> {
        var queue = LinkedList<String>()
        val result = mutableListOf<String>()

        queue = dfs(parentsToChildren.keys.firstOrNull(), queue)
        while (queue.isNotEmpty()) {
            val king = queue.poll()
            result.add(king)
        }
        return result.toList()
    }

    private fun dfs(parentName: String?, queue: LinkedList<String>): LinkedList<String> {
        if (aliveOrDead[parentName]!!) {
            queue.offer(parentName)
            parentsToChildren[parentName]?.forEach {
                dfs(it, queue)
            }
        } else {
            parentsToChildren[parentName]?.forEach {
                dfs(it, queue)
            }
        }
        return queue
    }
}




/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * var obj = ThroneInheritance(kingName)
 * obj.birth(parentName,childName)
 * obj.death(name)
 * var param_3 = obj.getInheritanceOrder()
 */