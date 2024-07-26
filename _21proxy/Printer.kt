package _21proxy

class Printer(override var name: String?) : Printable {
    init {
        heavyJob("Printer 인스턴스 생성 중 name = $name")
    }

    override fun print(string: String) {
        println("===$name===")
        println(string)
    }

    private fun heavyJob(message: String) {
        println(message)
        repeat(5) {
            Thread.sleep(1000)
            println(".")
        }
    }
}
