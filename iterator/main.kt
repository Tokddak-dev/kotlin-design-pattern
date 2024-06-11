package iterator

fun main() {
    val bookShelf = BookShelf(4)
    bookShelf.appendBook(Book("Around the World in 80 Days"))
    bookShelf.appendBook(Book("Bible"))
    bookShelf.appendBook(Book("Cinderella"))
    bookShelf.appendBook(Book("Daddy-Log-Legs"))

    val it = bookShelf.iterator()
    while (it.hasNext()) {
        val book = it.next()
        println(book.name)
    }

    bookShelf.books.forEach { println(it.name) }
}
