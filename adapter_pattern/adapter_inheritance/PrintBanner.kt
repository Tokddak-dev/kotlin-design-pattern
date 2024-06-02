package adapter_pattern.adapter_inheritance

class PrintBanner(string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }

    override fun printStrong() {
        showWithAster()
    }
}