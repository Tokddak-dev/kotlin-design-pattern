package _23interpreter.examples

// <command> ::= <repeat command> | <primitive command>
class CommandNode : Node() {
  private var node: Node? = null
  @Throws(ParseException::class)
  override fun parse(context: Context) {
    if (context.currentToken() == "repeat") {
      node = RepeatCommandNode()
      (node as RepeatCommandNode).parse(context)
    } else {
      node = PrimitiveCommandNode()
      (node as PrimitiveCommandNode).parse(context)
    }
  }
}
