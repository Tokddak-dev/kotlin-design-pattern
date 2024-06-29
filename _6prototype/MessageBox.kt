package _6prototype

class MessageBox(private val decochar: String): Product {
    override fun use(s: String) {
        println(decochar.repeat(s.length+2))
        println("$decochar$s$decochar")
        println(decochar.repeat(s.length+2))
    }

    override fun createCopy(): Product {
        return clone() as Product
    }
}
