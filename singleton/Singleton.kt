package singleton

/**
 * 싱글톤 패턴 예시 객체
 *
 * @see 104 페이지
 * @author toneyparky
 */
object Singleton {
  init {
    println("인스턴스를 생성했습니다.")
  }
}

fun main() {
  println("start")

  val obj1 = Singleton
  val obj2 = Singleton

  if (obj1 == obj2)
    println("obj1과 obj2는 같은 인스턴스입니다.")
  else
    println("obj1과 obj2는 같은 인스턴스가 아닙니다.")

  println("end")
}
