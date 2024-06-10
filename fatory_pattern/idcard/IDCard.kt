package fatory_pattern.idcard

import fatory_pattern.framework.Product

class IDCard constructor(
    private var owner: String
) : Product() {
    init {
        println("${owner}의 카드를 만듭니다.")
        // this.owner = owner // 해당 코드는 생략해도 동작함.
    }

    override fun use() {
        println("${owner}의 카드를 사용합니다.")
    }

    fun getOwner() = owner
}