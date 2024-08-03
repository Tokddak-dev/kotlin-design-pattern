package _20flyweight.questions._1

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class BigChar(charName: Char) {
  private var fontdata: String? = null

  init {
    fontdata = try {
      val filename = "big$charName.txt"
      val sb = StringBuilder()
      for (line in Files.readAllLines(Path.of(filename))) {
        sb.append(line)
        sb.append("\n")
      }
      sb.toString()
    } catch (e: IOException) {
      "$charName?"
    }
  }

  fun print() {
    print(fontdata)
  }
}
