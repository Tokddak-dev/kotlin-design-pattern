package _8abstractfactory.examples.factory

abstract class Tray(caption: String) : Item(caption) {
  protected var tray: MutableList<Item> = ArrayList()
  fun add(item: Item) {
    tray.add(item)
  }
}
