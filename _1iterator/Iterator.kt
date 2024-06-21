package _1iterator

interface Iterator<E> {
    fun hasNext(): Boolean
    fun next(): E
}
