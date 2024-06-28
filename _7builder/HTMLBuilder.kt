package _7builder

import java.io.FileWriter
import java.io.PrintWriter
import java.nio.charset.Charset

class HTMLBuilder : Builder() {
    private lateinit var filename: String
    private lateinit var writer: PrintWriter
    override fun innerMakeTitle(title: String) {
        filename = "$title.html"
        writer = PrintWriter(FileWriter(filename, Charset.defaultCharset(),))

        writer.println(
            """
            <html><head><title>$title</title>/<head><body>
            <h1>$title</h1>
            """.trimIndent()
        )

    }

    override fun innerMakeString(str: String) {
        writer.println("<p>$str</p>")
    }

    override fun innerMakeItems(items: Array<String>) {
        writer.println("<ul>")

        writer.println(items.map {
            "<li>$it</li>"
        }.toString())

        writer.println("</ul>")
    }

    override fun makeClose() {
        writer.println("</body></html>")
        writer.close()
    }

    fun getResult(): String = filename
}