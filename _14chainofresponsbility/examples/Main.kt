object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    val alice: Support = NoSupport("Alice")
    val bob: Support = LimitSupport("Bob", 100)
    val charlie: Support = SpecialSupport("Charlie", 429)
    val diana: Support = LimitSupport("Diana", 200)
    val elmo: Support = OddSupport("Elmo")
    val fred: Support = LimitSupport("Fred", 300)

    // 책임을 넘길 체인을 만든다. 원래는 클라이언트에서 만들면 안된다. 세부사항(구현체)이 드러나기 때문이다. 나라면 팩토리를 사용할 것이다. 그러나 여기서는 간단하게 구현하기 위해 메인에서 만든다.
    alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred)

    // 다양한 id 를 부여한 트러블 발생
    var i = 0
    while (i < 500) {
      alice.support(Trouble(i))
      i += 33
    }
  }
}
