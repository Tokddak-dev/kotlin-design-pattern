package _20flyweight.examples

class BigCharFactory  // 생성자 
private constructor() {
  private val pool: MutableMap<String, BigChar> = HashMap()

  @Synchronized
  fun getBigChar(charName: Char): BigChar {
    var bc = pool[charName.toString()]
    if (bc == null) {
      bc = BigChar(charName)
      pool[charName.toString()] = bc
    }
    return bc
  }

  companion object {
    fun getInstance(): BigCharFactory {
      return BigCharFactory()
    }
  }
}
