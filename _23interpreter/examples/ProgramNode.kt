package _23interpreter.examples

// <program> ::= program <command list>
class ProgramNode : Node() {
  private var commandListNode: Node? = null
  @Throws(ParseException::class)
  override fun parse(context: Context) {
    context.skipToken("program")
    commandListNode = CommandListNode()
    (commandListNode as CommandListNode).parse(context)
  }

  override fun toString(): String {
    return "[program $commandListNode]"
  }
}
