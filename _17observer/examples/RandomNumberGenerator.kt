package _17observer.examples

import java.util.*

class RandomNumberGenerator : NumberGenerator() {
  private val random = Random()

  override var number = 0
    private set

  override fun execute() {
    (0..19).forEach { _ ->
      number = random.nextInt(50)
      notifyObservers()
    }
  }
}
