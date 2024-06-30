package _10strategy

import kotlin.random.Random

class ProbStrategy : Strategy {
    private val random = Random
    private var won = false
    private var prevHandValue = 0
    private var currentHandValue = 0
    private val history = mutableListOf(
        mutableListOf(1, 1, 1),
        mutableListOf(1, 1, 1),
        mutableListOf(1, 1, 1),
    )
    private lateinit var prevHand: Hand

    override fun nextHand(): Hand {
        val bet = random.nextInt(getSum(currentHandValue))
        val handvalue = if (bet < history[currentHandValue][0]) 0
        else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) 1
        else 2
        prevHandValue = currentHandValue
        currentHandValue = handvalue
        return Hand.getHand(handvalue)
    }

    private fun getSum(hv: Int): Int {
        return history[hv].sum()
    }

    override fun study(win: Boolean) {
        if (win) history[prevHandValue][currentHandValue]++
        else {
            history[prevHandValue][(currentHandValue + 1) % 3]++
            history[prevHandValue][(currentHandValue + 2) % 3]++
        }
    }
}
