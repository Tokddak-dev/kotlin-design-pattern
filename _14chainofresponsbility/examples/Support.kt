abstract class Support(
  // 이 트러블 해결자 이름
  private val name: String
) {
  // 다음 번에 넘길 해결자
  private var next: Support? = null

  // 넘길 해결자를 설정한다
  fun setNext(next: Support): Support {
    this.next = next
    return next
  }

  // 트러블 해결 절차를 결정한다
  fun support(trouble: Trouble) {
    if (resolve(trouble)) {
      done(trouble)
    } else if (next != null) {
      next!!.support(trouble)
    } else {
      fail(trouble)
    }
  }

  override fun toString(): String {
    return "[$name]"
  }

  protected abstract fun resolve(trouble: Trouble): Boolean

  private fun done(trouble: Trouble) {
    println("$trouble is resolved by $this.")
  }

  private fun fail(trouble: Trouble) {
    println("$trouble cannot be resolved.")
  }
}
