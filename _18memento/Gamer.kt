package _18memento

import kotlin.random.Random

class Gamer(var money: Int) {
    private var fruits: MutableList<String> = mutableListOf()

    fun bet() {
        val dice = Random.nextInt(1, 7)
        when (dice) {
            1 -> {
                money += 100
                println("소지금이 증가했습니다.")
            }
            2 -> {
                money /= 2
                println("소지금이 절반으로 줄었습니다.")
            }
            6 -> {
                val f = getFruit()
                println("과일($f)를 받았습니다.")
                fruits.add(f)
            }
            else -> {
                println("변동 사항이 없습니다.")
            }
        }
    }

    fun createMemento(): Memento {
        return Memento(money).also {
            for (fruit in fruits) {
                if (fruit.startsWith("맛있는 ")) {
                    it.addFruit(fruit)
                }
            }
        }
    }

    fun restoreMemento(memento: Memento) {
        this.money = memento.money
        this.fruits = memento.fruits
    }

    private fun getFruit(): String {
        val fruit = fruitsNames[Random.nextInt(0, fruitsNames.size)]
        return if (Random.nextBoolean()) {
            "맛있는 $fruit"
        } else {
            fruit
        }
    }

    companion object {
        val fruitsNames = listOf("Apple", "Banana", "Pear", "O")
    }
}
