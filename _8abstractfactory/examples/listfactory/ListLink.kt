package _8abstractfactory.examples.listfactory

import _8abstractfactory.examples.factory.Link

class ListLink(caption: String, url: String) : Link(caption, url) {
  override fun makeHTML(): String {
    return "  <li><a href=\"$url\">$caption</a></li>\n"
  }
}
