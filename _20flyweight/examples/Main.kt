package _20flyweight.examples

import kotlin.system.exitProcess

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.isEmpty()) {
      exitProcess(0)
    }
    val bigString = BigString(args[0])
    bigString.print()
  }
}
