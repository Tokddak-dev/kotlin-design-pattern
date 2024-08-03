package _21proxy

class PrinterProxy(initialName: String?) : Printable {
    private var real: Printer? = null

    override var name: String? = initialName
        @Synchronized
        set(value) {
            field = value
            if (real != null) {
                real?.name = value
            }
        }

    override fun print(string: String) {
        realize()
        real?.print(string)
    }

    @Synchronized
    private fun realize() {
        if (real == null) {
            real = Printer(name)
        }
    }
}
