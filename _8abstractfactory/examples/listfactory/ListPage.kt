package _8abstractfactory.examples.listfactory

import _8abstractfactory.examples.factory.Page

class ListPage(title: String, author: String) : Page(title, author) {
  override fun makeHTML(): String {
    val sb = StringBuilder()
    sb.append("<!DOCTYPE html>\n")
    sb.append("<html><head><title>")
    sb.append(title)
    sb.append("</title></head>\n")
    sb.append("<body>\n")
    sb.append("<h1>")
    sb.append(title)
    sb.append("</h1>\n")
    sb.append("<ul>\n")
    for (item in content) {
      sb.append(item.makeHTML())
    }
    sb.append("</ul>\n")
    sb.append("<hr><address>")
    sb.append(author)
    sb.append("</address>\n")
    sb.append("</body></html>\n")
    return sb.toString()
  }
}
