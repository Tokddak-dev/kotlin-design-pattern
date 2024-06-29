package _6prototype

class UnderlinePen(private val ulchar: String): Product{
    override fun use(s: String) {
        println(s)
        println(ulchar.repeat(s.length))
    }

    override fun createCopy(): Product {
        return clone() as Product
    }
}
