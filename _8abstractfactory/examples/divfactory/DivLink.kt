package _8abstractfactory.examples.divfactory

import _8abstractfactory.examples.factory.Link

class DivLink(caption: String, url: String) : Link(caption, url) {
  override fun makeHTML(): String {
    return "<div class=\"LINK\"><a href=\"$url\">$caption</a></div>\n"
  }
}
