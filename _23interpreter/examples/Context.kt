package _23interpreter.examples

class Context(text: String) {
  private val tokens: Array<String>
  private var lastToken: String? = null
  private var index = 0

  init {
    tokens = text.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    nextToken()
  }

  fun nextToken(): String? {
    lastToken = if (index < tokens.size) {
      tokens[index++]
    } else {
      null
    }
    return lastToken
  }

  fun currentToken(): String? {
    return lastToken
  }

  @Throws(ParseException::class)
  fun skipToken(token: String) {
    if (currentToken() == null) {
      throw ParseException("Error: '$token' is expected, but no more token is found.")
    } else if (token != currentToken()) {
      throw ParseException("Error: '" + token + "' is expected, but '" + currentToken() + "' is found.")
    }
    nextToken()
  }

  @Throws(ParseException::class)
  fun currentNumber(): Int {
    if (currentToken() == null) {
      throw ParseException("Error: No more token.")
    }
    var number = 0
    number = try {
      currentToken()!!.toInt()
    } catch (e: NumberFormatException) {
      throw ParseException("Error: $e")
    }
    return number
  }
}
