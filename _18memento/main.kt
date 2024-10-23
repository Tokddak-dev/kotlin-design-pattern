package _18memento

fun main() {
    val gamer = Gamer(100)
    var memento = gamer.createMemento()

    for (x in 1..100) {
        println("====$x")
        println("상태: $gamer")

        // 게임을 진행한다.
        gamer.bet()

        println("소지금은 ${gamer.money}원이 되었습니다.")

        // Memento 취급 방법 결정
        if (gamer.money > memento.money) {
            println("많이 늘었으니 현재 상태를 저장하자!")
            memento = gamer.createMemento()
        } else if (gamer.money < memento.money / 2) {
            println("많이 줄었으니 이전 상태를 복원하자!")
            gamer.restoreMemento(memento)
        }
    }

    // 잠시 대기
    Thread.sleep(1000)
    println()
}
