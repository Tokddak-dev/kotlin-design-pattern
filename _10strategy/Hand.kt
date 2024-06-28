package _10strategy

class Hand(
    private val handvalue: Int
) {
    companion object {
        const val HANDVALUE_GUU = 0; // 주먹
        const val HANDVALUE_CHO = 1; // 가위
        const val HANDVALUE_PAA = 2; // 보
        val hand = listOf(
            Hand(HANDVALUE_GUU),
            Hand(HANDVALUE_CHO),
            Hand(HANDVALUE_PAA),
        )

        val name = listOf("주먹", "가위", "보")

        fun getHand(handvalue: Int) = hand[handvalue]
    }

    fun isStrongerThan(h: Hand) = fight(h) == 1
    fun isWeakerThan(h: Hand) = fight(h) == -1

    private fun fight(h: Hand): Int {
        return if (this == h) 0
        else if ((this.handvalue + 1) % 3 == h.handvalue) 1
        else -1
    }

    override fun toString() = name[handvalue]
}
