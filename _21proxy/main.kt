package _21proxy

fun main() {
    val p = PrinterProxy("Alice")
    println("이름은 현재 ${p.name} 입니다.")
    p.name = "Bob"
    println("이름은 현재 ${p.name} 입니다.")
    p.print("Hello World!")
}
