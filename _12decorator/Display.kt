package _12decorator

abstract class Display {
    abstract fun getColumns(): Int // 가로 문자수
    abstract fun getRows(): Int // 세로 행수
    abstract fun getRowText(row: Int): String // row 행째 문자열

    // 모든 행 표시
    fun show() {
        repeat(getRows()) { println(getRowText(it)) }
    }
}

class StringDisplay(val string: String) : Display() {
    override fun getColumns(): Int = string.length

    override fun getRows(): Int = 1

    override fun getRowText(row: Int): String {
        require(row == 0) { "0번째 행의 값을 취할 때만 string 필드를 반환" }
        return string
    }
}
