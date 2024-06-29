package _6prototype

fun main() {
    val manager = Manager()
    val upen = UnderlinePen("-")
    val mbox = MessageBox("*")
    val sbox = MessageBox("/")

    manager.register("string message", upen)
    manager.register("warning box", mbox)
    manager.register("slash box", sbox)

    val p1 = manager.create("string message")
    p1.use("Hi, there")
    val p2 = manager.create("warning box")
    p2.use("Hi, there")
    val p3 = manager.create("slash box")
    p3.use("Hi, there")
}
