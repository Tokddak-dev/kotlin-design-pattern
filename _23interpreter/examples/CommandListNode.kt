package _23interpreter.examples

// <command list> ::= <command>* end
class CommandListNode : Node() {
  private val list: MutableList<Node> = ArrayList()
  @Throws(ParseException::class)
  override fun parse(context: Context) {
    while (true) {
      if (context.currentToken() == null) {
        throw ParseException("Error: Missing 'end'")
      } else if (context.currentToken() == "end") {
        context.skipToken("end")
        break
      } else {
        val commandNode: Node = CommandNode()
        commandNode.parse(context)
        list.add(commandNode)
      }
    }
  }

  override fun toString(): String {
    return list.toString()
  }
}
