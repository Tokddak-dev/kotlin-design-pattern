class OddSupport(name: String) : Support(name) {
  override fun resolve(trouble: Trouble): Boolean {
    return trouble.number % 2 == 1
  }
}
