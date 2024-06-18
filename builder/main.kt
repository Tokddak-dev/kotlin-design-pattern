package builder

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        usage()
        exitProcess(0)
    }

    if (args[0] == "plain") {
        val textBuilder = TextBuilder()
        val director = Director(textBuilder)
        director.construct()
        println(textBuilder.getResult())
    } else if (args[0] == "html") {
        val htmlBuilder = HTMLBuilder()
        val director = Director(htmlBuilder)
        director.construct()
        println("${htmlBuilder.getResult()}가 작성되었습니다.")
    } else {
        usage()
        exitProcess(0)
    }
}

fun usage() {
    println(
        """
        Usage: kotlin Main plain 일반 텍스트로 문서작성
        Usage: kotlin Main html HTML 파일로 문서작성
        """.trimIndent()
    )
}