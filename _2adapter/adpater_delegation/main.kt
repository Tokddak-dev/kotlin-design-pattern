package _2adapter.adpater_delegation

fun main() {
    val printBanner = PrintBanner(Banner("Hello"))
    printBanner.printWeak()
    printBanner.printStrong()
}