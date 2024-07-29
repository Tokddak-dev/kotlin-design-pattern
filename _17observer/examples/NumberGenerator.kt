package _17observer.examples

abstract class NumberGenerator {
  private val observers: MutableList<Observer> = ArrayList()

  fun addObserver(observer: Observer) {
    observers.add(observer)
  }

  fun deleteObserver(observer: Observer) {
    observers.remove(observer)
  }

  fun notifyObservers() {
    for (observer in observers) {
      observer.update(this)
    }
  }

  abstract val number: Int

  abstract fun execute()
}
