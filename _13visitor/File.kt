package _13visitor

class File(
    private val name: String,
    private val size: Int,
) : Entry() {
    override fun getName() = name

    override fun getSize() = size

    override fun accept(v: Visitor) {
        v.visit(this)
    }
}