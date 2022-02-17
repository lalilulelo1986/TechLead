package techlead.common

import java.io.ByteArrayOutputStream
import java.io.Externalizable
import java.io.ObjectInput
import java.io.ObjectOutput
import java.io.ObjectOutputStream
import java.util.*

class Node<T>(
    var value: T?,
    var left: Node<T>? = null,
    var right: Node<T>? = null,
    var parent: Node<T>? = null
) : Externalizable {
    override fun toString(): String {
        return "Node(value=$value, left=$left, right=$right)"
    }

    override fun writeExternal(out: ObjectOutput) {
        val queue: Queue<Pair<Node<T>, Int>> = LinkedList()
        queue.add(this to 1)

        val sb = StringBuilder()
        var lastIndex = 0
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            for (i in 1 until polled.second - lastIndex)
                sb.append("#")
            sb.append(polled.first.value)
            lastIndex = polled.second
            polled.first.left?.also { queue.add(it to polled.second * 2) }
            polled.first.right?.also { queue.add(it to polled.second * 2 + 1) }
        }

        out.writeUTF(sb.toString())
    }

    override fun readExternal(`in`: ObjectInput) {
        val data = `in`.readUTF()
        if (data.isEmpty())
            return

        val queue: Queue<Pair<Node<T>, Int>> = LinkedList()
        val root: Node<T> = Node(data.first() as T)
        queue.add(root to 1)
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            polled.first.value = data[polled.second - 1] as T
            if (data.length >= polled.second * 2 && data[polled.second * 2 - 1] != '#')
                polled.first.left = Node("0" as T).also { queue.add(it to polled.second * 2) }
            if (data.length >= polled.second * 2 + 1 && data[polled.second * 2] != '#')
                polled.first.right = Node("0" as T).also { queue.add(it to polled.second * 2 + 1) }
        }
        this.value = root.value
        this.left = root.left
        this.right = root.right
//        println(root)
    }
}

fun generateNode(values: Array<Int>): Node<Int>? {
    return null
}

//class NodeObjectOutputStream : ObjectOutputStream(ByteArrayOutputStream()) {
//    private var buf: ByteArray? = null
//    override fun write(buf: ByteArray) {
//        this.buf = buf
//    }
//}