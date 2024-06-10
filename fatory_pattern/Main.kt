package fatory_pattern

import fatory_pattern.framework.Factory
import fatory_pattern.idcard.IDCardFactory

fun main() {
    val factory: Factory = IDCardFactory()
    val card1 = factory.create("홍길동")
    val card2 = factory.create("이순신")
    val card3 = factory.create("강감찬")
    card1.use()
    card2.use()
    card3.use()
}