package _18memento

class Memento(
    val money: Int
) {
    val fruits: MutableList<String> = mutableListOf()

    fun addFruit(fruit: String) {
        fruits.add(fruit)
    }
}
