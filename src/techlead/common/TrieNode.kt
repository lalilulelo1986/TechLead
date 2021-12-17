package techlead.common

class TrieNode(
    var value: String = "",
    var children: HashMap<Char, TrieNode> = hashMapOf(),
    var isWord: Boolean = false
) {
    override fun toString(): String {
        return "TrieNode(value='$value', children=$children, isWord=$isWord)"
    }
}