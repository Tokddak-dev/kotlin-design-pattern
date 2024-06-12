package singleton

/**
 * 연습 문제 5-3
 *
 * 어떤 사람이 singleton 클래스를 리스트 5-4처럼 만들었습니다. 그러나 이 상태에서 getInstance 메소드가 여러 스레드에서 호출되면 Singleton 패턴이 되지 않습니다. 어째서일까요?
 *
 * @see 108 페이지
 * @author toneyparky
 */

class InValidSingleton{
  init {
    println("인스턴스를 생성했습니다.")
  }

  companion object {
    // 이유 : singleton 이 null 로 할당된 상태에서 여러 스레드에서 동시에 getInstance 메소드를 호출할 경우, 인스턴스가 여러 개 생성될 수 있기 때문이다.
    private var singleton: InValidSingleton? = null

    fun getInstance(): InValidSingleton {
      if (singleton == null) {
        singleton = InValidSingleton()
      }
      return singleton!!
    }
  }
}
