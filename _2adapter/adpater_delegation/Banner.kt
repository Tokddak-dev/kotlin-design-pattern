package _2adapter.adpater_delegation

class Banner(
    private val string: String
) {
    fun showWithParen() {
        println("($string)")
    }

    fun showWithAster() {
        println("*$string*")
    }
}
