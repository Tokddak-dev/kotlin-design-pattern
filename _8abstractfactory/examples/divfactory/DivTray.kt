package _8abstractfactory.examples.divfactory

import _8abstractfactory.examples.factory.Tray

class DivTray(caption: String) : Tray(caption) {
  override fun makeHTML(): String {
    val sb = StringBuilder()
    sb.append("<p><b>")
    sb.append(caption)
    sb.append("</b></p>\n")
    sb.append("<div class=\"TRAY\">")
    for (item in tray) {
      sb.append(item.makeHTML())
    }
    sb.append("</div>\n")
    return sb.toString()
  }
}
