fun main(args: Array<String>) {

    val node = Node()
    node.add("hack")
    node.add("hackerrank")
    println("${node.findCount("hac", 0)}")
}

class Node {

    private var size = 0
    private val children = mutableMapOf<Char, Node?>()

    private fun getNode(c: Char): Node? {
        return children[c]
    }

    private fun setNode(c: Char, node: Node) {
        children[c] = node
    }

    fun add(word: String) {
        add(word, 0)
    }

    private fun add(word: String, index: Int) {
        size++

        if (index == word.length) return

        val current = word[index]
        var child = getNode(current)
        if (child == null) {
            child = Node()
            setNode(current, child)
        }
        child.add(word, index + 1)
    }

    fun findCount(word: String, index: Int) : Int {
        if (index == word.length) {
            return size
        }
        val node = getNode(word[index]) ?: return 0

        return node.findCount(word, index + 1)
    }
}

