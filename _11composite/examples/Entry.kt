package _11composite.examples

abstract class Entry {
  abstract fun getName(): String

  abstract fun getSize(): Int

  fun printList() {
    printList("")
  }

  // java 에서는 protected 로 선언하지만 코틀린의 protected 와는 다르므로 public 으로 선언한다.
  abstract fun printList(prefix: String)

  override fun toString(): String {
    return "${getName()} (${getSize()})"
  }
}
