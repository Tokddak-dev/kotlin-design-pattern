package _17observer.examples

class GraphObserver : Observer {
  override fun update(generator: NumberGenerator) {
    print("GraphObserver:")
    val count = generator.number
    for (i in 0 until count) {
      print("*")
    }
    println("")
    try {
      Thread.sleep(100)
    } catch (_: InterruptedException) {
    }
  }
}
