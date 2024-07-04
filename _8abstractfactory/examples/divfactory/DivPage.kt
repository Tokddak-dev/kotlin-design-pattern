package _8abstractfactory.examples.divfactory

import _8abstractfactory.examples.factory.Page

class DivPage(title: String, author: String) : Page(title, author) {
  override fun makeHTML(): String {
    val sb = StringBuilder()
    sb.append("<!DOCTYPE html>\n")
    sb.append("<html><head><title>")
    sb.append(title)
    sb.append("</title><style>\n")
    sb.append("div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }\n")
    sb.append("div.LINK { padding:0.5em; background-color: lightgray; }\n")
    sb.append("</style></head><body>\n")
    sb.append("<h1>")
    sb.append(title)
    sb.append("</h1>\n")
    for (item in content) {
      sb.append(item.makeHTML())
    }
    sb.append("<hr><address>")
    sb.append(author)
    sb.append("</address>\n")
    sb.append("</body></html>\n")
    return sb.toString()
  }
}
