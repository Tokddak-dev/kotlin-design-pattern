package _17observer.questions

import _17observer.examples.NumberGenerator

class IncrementalNumberGenerator(
  override var number: Int,
  private val end: Int,
  private val inc: Int
) : NumberGenerator() {
  override fun execute() {
    while (number < end) {
      notifyObservers()
      number += inc
    }
  }
}
