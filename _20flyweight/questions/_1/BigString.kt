package _20flyweight.questions._1

class BigString {
  private var bigChars: Array<BigChar?> = emptyArray()

  constructor(string: String) {
    initShared(string)
  }

  constructor(string: String, shared: Boolean) {
    if (shared) {
      initShared(string)
    } else {
      initUnshared(string)
    }
  }

  private fun initShared(string: String) {
    val factory: BigCharFactory = BigCharFactory.getInstance()
    bigChars = arrayOfNulls(string.length)
    for (i in bigChars.indices) {
      bigChars[i] = factory.getBigChar(string[i])
    }
  }

  private fun initUnshared(string: String) {
    bigChars = arrayOfNulls(string.length)
    for (i in bigChars.indices) {
      bigChars[i] = BigChar(string[i])
    }
  }

  fun print() {
    for (bigChar in bigChars) {
      bigChar!!.print()
    }
  }
}
