package _23interpreter.examples.dsl

object DslMain {
  @JvmStatic
  fun main(args: Array<String>) {
    try {
      val context = Context("program repeat 2 repeat 3 go end end")
      val programNode = program {
        commandList {
          command {
            repeat(2) {
              command {
                repeat(3) {
                  command {
                    primitive("go")
                  }
                }
              }
            }
          }
        }
      }
      programNode.parse(context)
      println(programNode)
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}