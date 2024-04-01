/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {

        val sb = StringBuilder()
        serializeHelper(root,sb)
        return sb.toString()
    }

    private fun serializeHelper(node: TreeNode?, sb: StringBuilder) {

        if(node == null){
            sb.append("null").append(",")
            return
        }
        sb.append(node.`val`).append(",")
        serializeHelper(node.left,sb)
        serializeHelper(node.right,sb)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val nodes = data.split(",")
        val queue = LinkedList<String>()
        queue.addAll(nodes)
        return deserializeHelper(queue)
    }

    private fun deserializeHelper(queue: LinkedList<String>): TreeNode? {
        val value = queue.poll()
        
        if(value == "null")
            return null

        val node = TreeNode(value.toInt())
        node.left = deserializeHelper(queue)
        node.right = deserializeHelper(queue)

        return node 
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */