package _20flyweight.examples

class BigString(string: String) {
  private val bigChars: Array<BigChar?>

  init {
    val factory: BigCharFactory = BigCharFactory.getInstance()
    bigChars = arrayOfNulls(string.length)
    for (i in bigChars.indices) {
      bigChars[i] = factory.getBigChar(string[i])
    }
  }

  fun print() {
    for (bc in bigChars) {
      bc!!.print()
    }
  }
}
