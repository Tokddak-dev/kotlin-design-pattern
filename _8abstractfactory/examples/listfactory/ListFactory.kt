package _8abstractfactory.examples.listfactory

import _8abstractfactory.examples.factory.Factory
import _8abstractfactory.examples.factory.Link
import _8abstractfactory.examples.factory.Page
import _8abstractfactory.examples.factory.Tray

class ListFactory : Factory() {
  override fun createLink(caption: String, url: String): Link {
    return ListLink(caption, url)
  }

  override fun createTray(caption: String): Tray {
    return ListTray(caption)
  }

  override fun createPage(title: String, author: String): Page {
    return ListPage(title, author)
  }
}
