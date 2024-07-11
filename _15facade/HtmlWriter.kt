package _15facade

import java.io.Writer

class HtmlWriter(private val writer: Writer) {
    fun title(title: String) {
        writer.write("<!DOCTYPE html>")
        writer.write("<html>")
        writer.write("<head>")
        writer.write("<title>$title</title>")
        writer.write("</head>")
        writer.write("<body>")
        writer.write("\n")
        writer.write("<h1>$title</h1>")
        writer.write("\n")
    }

    fun paragraph(msg: String) {
        writer.write("<p>$msg</p>")
        writer.write("\n")
    }

    fun link(href: String, caption: String) {
        paragraph("<a href=\"$href\">$caption</a>")
    }

    fun mailto(mailaddr: String, username: String) {
        link("mainto: $mailaddr", username)
    }

    fun close() {
        writer.write("</body></html>")
        writer.write("\n")
        writer.close()
    }
}