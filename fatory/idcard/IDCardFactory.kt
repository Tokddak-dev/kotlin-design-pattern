package fatory.idcard

import fatory.framework.Factory
import fatory.framework.Product

class IDCardFactory: Factory() {
    private val owners = mutableListOf<String>()

    override fun createProduct(owner: String): Product = IDCard(owner)

    override fun registerProduct(product: Product) {
        owners.add((product as IDCard).getOwner())
    }
}