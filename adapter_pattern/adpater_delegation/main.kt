package adapter_pattern.adpater_delegation

fun main() {
    val printBanner = PrintBanner(Banner("Hello"))
    printBanner.printWeak()
    printBanner.printStrong()
}