class NoSupport(name: String) : Support(name) {
  override fun resolve(trouble: Trouble): Boolean {
    // 자신은 아무것도 해결하지 않는다
    return false
  }
}
