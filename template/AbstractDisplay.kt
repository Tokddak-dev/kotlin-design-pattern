package template

abstract class AbstractDisplay {
    protected abstract fun open()
    protected abstract fun print()
    protected abstract fun close()

    /*
     * in Java: public final void display()
     * Kotlin에서는 open 이 붙어있지 않으면 모두 final
     */
    fun display() {
        open()
        (0 until 5).forEach { print() }
        close()
    }
}
