package _7builder

abstract class Builder {
    private var isMakeTitle: Boolean = false

    fun makeTitle(title: String) {
        isMakeTitle = true
        innerMakeTitle(title)
    }

    fun makeString(str: String) {
        if(isMakeTitle) {
            innerMakeString(str)
        }
    }

    fun makeItems(items: Array<String>) {
        if(isMakeTitle) {
            innerMakeItems(items)
        }
    }

    fun close() {
        if(isMakeTitle) {
            makeClose()
        }
    }

    protected abstract fun innerMakeTitle(title: String)
    protected abstract fun innerMakeString(str: String)
    protected abstract fun innerMakeItems(items: Array<String>)
    protected abstract fun makeClose()
}