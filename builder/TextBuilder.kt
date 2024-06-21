package builder

class TextBuilder : Builder() {
    private val buffer = StringBuffer()
    override fun innerMakeTitle(title: String) {
        buffer.append("=========\n")
        buffer.append("[$title]\n")
        buffer.append("\n")
    }

    override fun innerMakeString(str: String) {
        buffer.append("- $str\n")
        buffer.append("\n")
    }

    override fun innerMakeItems(items: Array<String>) {
        items.forEach {
            buffer.append("  > $it\n")
        }
    }

    override fun makeClose() {
        buffer.append("=========\n")
    }

    fun getResult(): String = buffer.toString()
}