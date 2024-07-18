class LimitSupport(
  name: String,
  // 이 번호 미만이면 해결할 수 있다
  private val limit: Int
) : Support(name) {
  override fun resolve(trouble: Trouble): Boolean {
    return trouble.number < limit
  }
}
