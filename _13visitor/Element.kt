package _13visitor

interface Element {
    fun accept(v: Visitor)
}
