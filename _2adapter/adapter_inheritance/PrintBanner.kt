package _2adapter.adapter_inheritance

class PrintBanner(string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }

    override fun printStrong() {
        showWithAster()
    }
}