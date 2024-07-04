class SpecialSupport(
  // 이 번호만 해결할 수 있다.
  name: String,
  private val number: Int
) : Support(name) {
  override fun resolve(trouble: Trouble): Boolean {
    return trouble.number == number
  }
}
