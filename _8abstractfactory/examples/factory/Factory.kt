package _8abstractfactory.examples.factory

abstract class Factory {
  abstract fun createLink(caption: String, url: String): Link
  abstract fun createTray(caption: String): Tray
  abstract fun createPage(title: String, author: String): Page

  companion object {
    fun getFactory(classname: String): Factory {
      var factory: Factory? = null
      try {
        factory = Class.forName(classname).getDeclaredConstructor().newInstance() as Factory
      } catch (e: ClassNotFoundException) {
        println("$classname 클래스가 발견되지 않았습니다.")
      } catch (e: Exception) {
        e.printStackTrace()
      }
      return factory ?: throw ClassNotFoundException("$classname 클래스가 발견되지 않았습니다.")
    }
  }
}
