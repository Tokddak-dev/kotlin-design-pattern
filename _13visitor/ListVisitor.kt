package _13visitor

class ListVisitor: Visitor {
    var currentdir = ""
    override fun visit(file: File) {
        println("$currentdir/$file")
    }

    override fun visit(directory: Directory) {
        println("$currentdir/$directory")
        val savedir = currentdir
        currentdir = "$currentdir/${directory.getName()}"
        val iterator = directory.iterator()
        while(iterator.hasNext()) {
            val entry = iterator.next()
            entry.accept(this)
        }
        currentdir = savedir
    }

}