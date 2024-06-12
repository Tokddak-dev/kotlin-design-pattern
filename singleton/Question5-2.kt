package singleton

/**
 * 연습 문제 5-2
 *
 * 인스턴스 수가 3개로 제한되는 클래스 Triple을 만드세요. 인스턴스에는 "ALPHA", "BETA" , "GAMMA" 라는 가정합니다.
 * 이름이 붙어 있고, getInstance(String name) 으로 name이라는 이름을 가진 인스턴스를 얻을 수 있다고 가정합니다.
 *
 * @see 108 페이지
 * @author toneyparky
 */

enum class Triple {
  ALPHA, BETA, GAMMA;

  fun getInstance(name: String): Triple {
    return valueOf(name)
  }
}

fun main() {
  // Enum 클래스는 싱글톤이다.
  val alpha = Triple.ALPHA.getInstance("ALPHA")
  val beta = Triple.BETA.getInstance("BETA")
  val gamma = Triple.GAMMA.getInstance("GAMMA")

  val alpha2 = Triple.ALPHA.getInstance("ALPHA")
  val beta2 = Triple.BETA.getInstance("BETA")
  val gamma2 = Triple.GAMMA.getInstance("GAMMA")

  println("${Triple.ALPHA} equality test : $alpha == $alpha2 is ${alpha == alpha2}")
  println("${Triple.BETA} equality test : $beta == $beta2 is ${beta == beta2}")
  println("${Triple.GAMMA} equality test : $gamma == $gamma2 is ${gamma == gamma2}")
}
