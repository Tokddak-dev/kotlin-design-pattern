package template

interface Display {
    fun open()
    fun print()
    fun close()

    /*
     * default method in Kotlin
     * kotlin에서는 java 처럼 default 키워드를 붙이지 않아도 interface에서 메소드 구현이 가능하다.
     * 아래 코드를 실제 java로 decompile해보면 default 메소드로 구현되어 있지 않고 DefaultImpls 라는 static class가 별도로 구현되어 있다.
     * default 키워드가 등장하기 전인 java 1.6 부터의 호환성을 보완하기 위해서라고 한다.
     */
    fun display() {
        open()
        (0 until 5).forEach { print() }
        close()
    }
}
