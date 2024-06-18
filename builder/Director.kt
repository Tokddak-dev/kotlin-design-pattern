package builder

class Director(
    private val builder: Builder
) {
    fun construct() {
        builder.makeTitle("Greeting")
        builder.makeString("아침과 낮에")
        builder.makeItems(arrayOf(
            "좋은 아침입니다.",
            "안녕하세요",
        ))

        builder.makeString("밤에")
        builder.makeItems(arrayOf(
            "안녕하세요.",
            "안녕히 주무세요",
            "안녕히 계세요",
        ))
        builder.close()
    }
}