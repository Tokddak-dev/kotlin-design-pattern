package _10strategy

fun main() {
    // kotlin에서 random seed는 필요없어보여서 args는 생략했음.

    val player1 = Player("두리", WinningStrategy())
    val player2 = Player("하나", ProbStrategy())

    for (i: Int in 0..9999) {
        val nextHand1 = player1.nextHand()
        val nextHand2 = player2.nextHand()

        if(nextHand1.isStrongerThan(nextHand2)) {
            println("Winner: $player1")
            player1.win()
            player2.lose()
        } else if(nextHand1.isWeakerThan(nextHand2)) {
            println("Winner: $player2")
            player2.win()
            player1.lose()
        } else {
            println("Even...")
            player1.even()
            player2.even()
        }
    }

    println("Total result:")
    println(player1.toString())
    println(player2.toString())
}