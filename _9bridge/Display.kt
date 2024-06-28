package _9bridge

/**
 * 추상화
 * 구현자의 메소드를 사용해서 기본 기능만 기술
 */
open class Display(
    private val impl: DisplayImpl
) {
    fun open() {
        impl.rawOpen()
    }

    fun print() {
        impl.rawPrint()
    }

    fun close() {
        impl.rawClose()
    }

    fun display() {
        open()
        print()
        close()
    }
}
