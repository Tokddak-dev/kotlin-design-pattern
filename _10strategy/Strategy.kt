package _10strategy

interface Strategy {
    fun nextHand(): Hand
    fun study(win: Boolean)
}