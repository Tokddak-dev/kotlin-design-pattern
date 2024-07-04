package _9bridge

/**
 * 구체적인 구현자
 * 실제로 구현자의 메소드를 구현함
 */
class StringDisplayImpl(
    val string: String
) : DisplayImpl() {
    private val width = string.length

    override fun rawOpen() {
        printLine()
    }

    override fun rawPrint() {
        println("|$string|")
    }

    override fun rawClose() {
        printLine()
    }

    private fun printLine() {
        print("+")
        repeat(width) { print("-") }
        print("+")
    }
}
