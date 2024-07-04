package _8abstractfactory.examples.factory

abstract class Item(protected var caption: String) {
  abstract fun makeHTML(): String
}
