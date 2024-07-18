package _13visitor

class Directory(
    private val name: String
) : Entry() {
    private val dir = mutableListOf<Entry>()

    override fun getName() = name

    override fun getSize() = dir.sumOf{ it.getSize()}

    override fun add(entry: Entry): Entry {
        dir.add(entry)
        return this
    }

    override fun iterator(): Iterator<Entry> {
        return dir.iterator()
    }

    override fun accept(v: Visitor) {
        v.visit(this)
    }
}