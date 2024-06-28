package _10strategy

class Player(
    private val name: String,
    private val strategy: Strategy,
) {
    var winCount = 0
    var loseCount = 0
    var gameCount = 0

    fun nextHand() = strategy.nextHand()

    fun win() {
        strategy.study(win = true)
        winCount++
        gameCount++
    }

    fun lose() {
        strategy.study(win = false)
        loseCount++
        gameCount++
    }

    fun even() = gameCount++

    override fun toString(): String {
        return "[$name : $gameCount games, $winCount win, ${loseCount} lose]"
    }
}