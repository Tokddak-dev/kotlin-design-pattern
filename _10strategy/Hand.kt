package _10strategy

enum class Hand(
    private val handvalue: Int
) {
    HANDVALUE_GUU(0), // 주먹
    HANDVALUE_CHO(1), // 가위
    HANDVALUE_PAA(2), // 보
    ;

    companion object {

        private val hand = mapOf(
            0 to HANDVALUE_GUU,
            1 to HANDVALUE_CHO,
            2 to HANDVALUE_PAA,
        )

        val name = listOf("주먹", "가위", "보")

        fun getHand(handvalue: Int) = hand.getValue(handvalue)
    }

    fun isStrongerThan(h: Hand) = fight(h) == 1
    fun isWeakerThan(h: Hand) = fight(h) == -1

    private fun fight(h: Hand): Int {
        return if (this == h) 0
        else if ((this.handvalue + 1) % 3 == h.handvalue) 1
        else -1
    }

    override fun toString(): String = Hand.name[handvalue]
}
