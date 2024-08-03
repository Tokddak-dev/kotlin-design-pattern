package _23interpreter.examples

// <repeat command> ::= repeat <number> <command list>
class RepeatCommandNode : Node() {
  private var number = 0
  private var commandListNode: Node? = null
  @Throws(ParseException::class)
  override fun parse(context: Context) {
    context.skipToken("repeat")
    number = context.currentNumber()
    context.nextToken()
    commandListNode = CommandListNode()
    (commandListNode as CommandListNode).parse(context)
  }

  override fun toString(): String {
    return "[repeat $number $commandListNode]"
  }
}
