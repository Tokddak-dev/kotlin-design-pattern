package _11composite.examples

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    println("Making root entries...")
    val rootDir = Directory("root")
    val binDir = Directory("bin")
    val tmpDir = Directory("tmp")
    val usrDir = Directory("usr")

    rootDir.add(binDir)
    rootDir.add(tmpDir)
    rootDir.add(usrDir)
    binDir.add(File("vi", 10000))
    binDir.add(File("latex", 20000))
    rootDir.printList()
    println()
    println("Making user entries...")

    val youngjin = Directory("youngjin")
    val gildong = Directory("gildong")
    val dojun = Directory("dojun")

    usrDir.add(youngjin)
    usrDir.add(gildong)
    usrDir.add(dojun)
    youngjin.add(File("diary.html", 100))
    youngjin.add(File("Composite.java", 200))
    gildong.add(File("memo.tex", 300))
    dojun.add(File("game.doc", 400))
    dojun.add(File("junk.mail", 500))
    rootDir.printList()
  }
}
