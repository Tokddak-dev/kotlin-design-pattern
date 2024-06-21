package _8abstractfactory.examples

import _8abstractfactory.examples.factory.Factory
import _8abstractfactory.examples.factory.Link
import _8abstractfactory.examples.factory.Page
import _8abstractfactory.examples.factory.Tray
import kotlin.system.exitProcess

object AbstractFactoryMain {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.size != 2) {
      println("인자 추가 방법: filename.html class.name.of.ConcreteFactory")
      println("List 예시: 인텔리제이의 AbstractFactoryMain 실행 설정 > Program arguments에 다음 인자 추가 > _8abstractfactory/examples/list.html _8abstractfactory.examples.listfactory.ListFactory")
      println("Div 예시: 인텔리제이의 AbstractFactoryMain 실행 설정 > Program arguments에 다음 인자 추가 > _8abstractfactory/examples/div.html _8abstractfactory.examples.divfactory.DivFactory")
      exitProcess(0)
    }
    val filename = args[0]
    val classname = args[1]
    val factory: Factory = Factory.getFactory(classname)

    // Blog
    val blog1: Link = factory.createLink("Blog 1", "https://example.com/blog1")
    val blog2: Link = factory.createLink("Blog 2", "https://example.com/blog2")
    val blog3: Link = factory.createLink("Blog 3", "https://example.com/blog3")
    val blogTray: Tray = factory.createTray("Blog Site")
    blogTray.add(blog1)
    blogTray.add(blog2)
    blogTray.add(blog3)

    // News
    val news1: Link = factory.createLink("News 1", "https://example.com/news1")
    val news2: Link = factory.createLink("News 2", "https://example.com/news2")
    val news3: Tray = factory.createTray("News 3")
    news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"))
    news3.add(factory.createLink("News 3 (Korea)", "https://example.com/news3kr"))
    val newsTray: Tray = factory.createTray("News Site")
    newsTray.add(news1)
    newsTray.add(news2)
    newsTray.add(news3)

    // Page
    val page: Page = factory.createPage("Blog and News", "Youngjin.com")
    page.add(blogTray)
    page.add(newsTray)
    page.output(filename)
  }
}

