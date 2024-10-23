package _20flyweight.questions._1

import kotlin.system.exitProcess

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.isEmpty()) {
      exitProcess(0)
    }
    var bigString: BigString
    bigString = BigString(args[0], false)
    bigString.print()
    bigString = BigString(args[0], true)
    bigString.print()
  }
}
