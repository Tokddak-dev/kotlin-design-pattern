package _17observer.examples

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    val generator: NumberGenerator = RandomNumberGenerator()
    val observer1: Observer = DigitObserver()
    val observer2: Observer = GraphObserver()
    generator.addObserver(observer1)
    generator.addObserver(observer2)
    generator.execute()
  }
}
