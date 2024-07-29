package _23interpreter.examples.dsl

import _23interpreter.examples.ParseException

class Context(private val text: String) {
  private val tokens: List<String> = text.split("\\s+".toRegex()).filter { it.isNotEmpty() }
  private var index = 0

  fun nextToken(): String? = tokens.getOrNull(index++)
  fun currentToken(): String? = tokens.getOrNull(index)
  fun skipToken(token: String) {
    if (currentToken() != token) throw ParseException("Expected '$token' but found '${currentToken()}'")
    nextToken()
  }

  fun currentNumber(): Int =
    currentToken()?.toIntOrNull() ?: throw ParseException("Expected a number but found '${currentToken()}'")
}

abstract class Node {
  @Throws(ParseException::class)
  abstract fun parse(context: Context)
}

class ProgramNode : Node() {
  var commandListNode: CommandListNode? = null

  @Throws(ParseException::class)
  override fun parse(context: Context) {
    context.skipToken("program")
    commandListNode = CommandListNode().apply { parse(context) }
  }

  override fun toString(): String = "[program $commandListNode]"
}

class CommandListNode : Node() {
  val commandNodes = mutableListOf<Node>()

  @Throws(ParseException::class)
  override fun parse(context: Context) {
    while (context.currentToken() != null && context.currentToken() != "end") {
      val commandNode = CommandNode().apply { parse(context) }
      commandNodes.add(commandNode)
    }
  }

  override fun toString(): String = commandNodes.joinToString(" ")
}

class CommandNode : Node() {
  var node: Node? = null

  @Throws(ParseException::class)
  override fun parse(context: Context) {
    node = when (context.currentToken()) {
      "repeat" -> RepeatCommandNode().apply { parse(context) }
      else -> PrimitiveCommandNode().apply { parse(context) }
    }
  }

  override fun toString(): String = node.toString()
}

class RepeatCommandNode : Node() {
  var number = 0
  var commandListNode: CommandListNode? = null

  @Throws(ParseException::class)
  override fun parse(context: Context) {
    context.skipToken("repeat")
    number = context.currentNumber()
    context.nextToken()
    commandListNode = CommandListNode().apply { parse(context) }
  }

  override fun toString(): String = "[repeat $number $commandListNode]"
}

class PrimitiveCommandNode : Node() {
  var name: String? = null

  @Throws(ParseException::class)
  override fun parse(context: Context) {
    name = context.currentToken()
    context.nextToken()
  }

  override fun toString(): String = name ?: ""
}

fun program(init: ProgramNode.() -> Unit): ProgramNode {
  return ProgramNode().apply(init)
}

fun ProgramNode.commandList(init: CommandListNode.() -> Unit) {
  commandListNode = CommandListNode().apply(init)
}

fun CommandListNode.command(init: CommandNode.() -> Unit) {
  val commandNode = CommandNode().apply(init)
  commandNodes.add(commandNode)
}

fun CommandNode.repeat(number: Int, init: CommandListNode.() -> Unit) {
  node = RepeatCommandNode().apply {
    this.number = number
    commandListNode = CommandListNode().apply(init)
  }
}

fun CommandNode.primitive(name: String) {
  node = PrimitiveCommandNode().apply {
    this.name = name
  }
}
