package _12decorator

fun main() {
    val b1 = StringDisplay("Hello World")
    val b2 = SideBolder(b1, '#')
    val b3 = FullBolder(b2)
    println(b3.getRows())
    b1.show()
    b2.show()
    b3.show()

    val b4: Display = SideBolder(FullBolder(FullBolder(SideBolder(FullBolder(StringDisplay("Hello World")), '*'))), '/')
    b4.show()
}
