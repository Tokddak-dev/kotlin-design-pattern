package _20flyweight.questions._1

class BigCharFactory private constructor() {
  private val pool: MutableMap<String, BigChar> = HashMap()

  @Synchronized
  fun getBigChar(charName: Char): BigChar {
    var bigChar = pool[charName.toString()]
    if (bigChar == null) {
      bigChar = BigChar(charName)
      pool[charName.toString()] = bigChar
    }
    return bigChar
  }

  companion object {
    fun getInstance(): BigCharFactory {
      return BigCharFactory()
    }
  }
}
