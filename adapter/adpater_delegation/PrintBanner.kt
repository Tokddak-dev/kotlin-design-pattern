package adapter.adpater_delegation

class PrintBanner(
    private val banner: Banner
) : Print() {

    override fun printWeak() {
        banner.showWithParen()
    }

    override fun printStrong() {
        banner.showWithAster()
    }
}