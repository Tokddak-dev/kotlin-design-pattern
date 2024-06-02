package adapter_pattern.adapter_inheritance

fun main() {
    val printBanner = PrintBanner("Hello")
    printBanner.printWeak()
    printBanner.printStrong()
}