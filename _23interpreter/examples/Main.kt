package _23interpreter.examples

import java.nio.file.Files
import java.nio.file.Path

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    try {
      for (text in Files.readAllLines(Path.of("program.txt"))) {
        println("text = \"$text\"")
        val node: Node = ProgramNode()
        node.parse(Context(text))
        println("node = $node")
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}
