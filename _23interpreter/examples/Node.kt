package _23interpreter.examples

abstract class Node {
  @Throws(ParseException::class)
  abstract fun parse(context: Context)
}
