package _12decorator

// 장식틀과 내용물을 동일시할 수 있다.
abstract class Bolder(val display: Display) : Display()

class SideBolder(display: Display, private val bolderChar: Char) : Bolder(display) {
    override fun getColumns() = 1 + display.getColumns() + 1
    override fun getRows() = display.getRows()
    override fun getRowText(row: Int) = bolderChar + display.getRowText(row) + bolderChar
}

class FullBolder(display: Display) : Bolder(display) {
    override fun getColumns() = 1 + display.getColumns() + 1
    override fun getRows() = 1 + display.getRows() + 1
    override fun getRowText(row: Int) = when (row) {
        0 -> "+${"-".repeat(getColumns())}+"
        display.getRows() + 1 -> "+${"-".repeat(getColumns())}+"
        else -> "|${display.getRowText(row - 1)}|"
    }
}
