package _9bridge

/**
 * 개선된 추상화
 * 추상화에 기능 추가
 */
class CountDisplay(impl: DisplayImpl) : Display(impl) {
    fun multiDisplay(times: Int) {
        open()
        for (i in 0..times) {
            print()
        }
        close()
    }
}
