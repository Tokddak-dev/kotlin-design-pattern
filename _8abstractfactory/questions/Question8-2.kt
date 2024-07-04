package _8abstractfactory.questions

import _8abstractfactory.examples.factory.Link
import _8abstractfactory.examples.factory.Page
import _8abstractfactory.examples.factory.Tray
import kotlin.system.exitProcess

/**
 * 문제 8-2
 * 예제 프로그램의 Factory 클래스(리스트 8-5)에 Naver(https://www.naver.com/)의 링크만으로 구성 된 페이지를 만드는 구상 메소드'를 정의하세요
 * (페이지의 저자와 제목은 모두 "Naver"라고 합시다).
 *
 * ```
 * public Page createNaverPage()
 * ```
 *
 * 이때, 구체적인 공장이나 구체적인 부품은 어떻게 수정해야 할까요?
 */

abstract class QuestionFactory {
  fun createNaverPage(): Page {
    val link = createLink("Naver", "https://www.naver.com/")
    val page = createPage("Naver", "Naver")
    page.add(link)
    return page
  }


  // 아래 부분은 예제의 Factory 클래스와 동일합니다.
  abstract fun createLink(caption: String, url: String): Link
  abstract fun createTray(caption: String): Tray
  abstract fun createPage(title: String, author: String): Page

  companion object {
    fun getFactory(classname: String): QuestionFactory {
      var factory: QuestionFactory? = null
      try {
        factory = Class.forName(classname).getDeclaredConstructor().newInstance() as QuestionFactory
      } catch (e: ClassNotFoundException) {
        println("$classname 클래스가 발견되지 않았습니다.")
      } catch (e: Exception) {
        e.printStackTrace()
      }
      return factory ?: throw ClassNotFoundException("$classname 클래스가 발견되지 않았습니다.")
    }
  }
}

object QuestionAbstractFactoryMain {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.size != 2) {
      exitProcess(0)
    }
    val filename = args[0]
    val classname = args[1]
    val factory: QuestionFactory = QuestionFactory.getFactory(classname)

    // 네이버 페이지 생성
    val page: Page = factory.createNaverPage()
    page.output(filename)
  }
}

