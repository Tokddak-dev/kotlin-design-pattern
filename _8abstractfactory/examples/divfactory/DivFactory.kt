package _8abstractfactory.examples.divfactory

import _8abstractfactory.examples.factory.Factory
import _8abstractfactory.examples.factory.Link
import _8abstractfactory.examples.factory.Page
import _8abstractfactory.examples.factory.Tray

class DivFactory : Factory() {
  override fun createLink(caption: String, url: String): Link {
    return DivLink(caption, url)
  }

  override fun createTray(caption: String): Tray {
    return DivTray(caption)
  }

  override fun createPage(title: String, author: String): Page {
    return DivPage(title, author)
  }
}
