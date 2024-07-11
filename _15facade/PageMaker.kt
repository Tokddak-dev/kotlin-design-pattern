package _15facade

import java.io.FileWriter

class PageMaker {
    companion object {
        fun makeWelcomePage(mailaddr: String, filename: String) {
            runCatching {
                val mailProp = Database.getProperties("maildata")
                val username = mailProp.getProperty(mailaddr)
                val writer = HtmlWriter(FileWriter("./_15facade/$filename"))
                writer.title("$username's web page")
                writer.paragraph("Welcome to $username's web page")
                writer.paragraph("Nice to meet you")
                writer.mailto(mailaddr, username)
                writer.close()
                println("$filename is created for $mailaddr ($username)")
            }.onFailure { e ->
                e.printStackTrace()
            }
        }
    }
}