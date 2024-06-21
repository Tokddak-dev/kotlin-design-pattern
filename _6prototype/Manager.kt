package _6prototype

class Manager {
    private val showcase = HashMap<String, Product>()

    fun register(name: String, prototype: Product) {
        showcase[name] = prototype
    }

    fun create(prototypeName: String): Product {
        val p = showcase[prototypeName]
        require(p != null) { "등록되지 않은 프로토타입" }
        return p.createCopy()
    }
}
