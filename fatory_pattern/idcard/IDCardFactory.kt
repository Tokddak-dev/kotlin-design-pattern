package fatory_pattern.idcard

import fatory_pattern.framework.Factory
import fatory_pattern.framework.Product

class IDCardFactory: Factory() {
    private val owners = mutableListOf<String>()

    override fun createProduct(owner: String): Product = IDCard(owner)

    override fun registerProduct(product: Product) {
        owners.add((product as IDCard).getOwner())
    }
}