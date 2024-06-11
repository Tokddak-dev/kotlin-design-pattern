package iterator

class BookShelf(private val maxSize: Int): Iterable<Book> {
    val books: MutableList<Book> = mutableListOf()
    private var last = 0
    val length: Int get() = last

    fun appendBook(book: Book) {
        if (books.size < maxSize) {
            books.add(book)
            last ++
        }
    }

    fun getBookAt(index: Int): Book {
        return books[index]
    }

    override fun iterator(): Iterator<Book> {
        return BookShelfIterator(this)
    }
}
