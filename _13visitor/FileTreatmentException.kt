package _13visitor

class FileTreatmentException(
    private val msg: String? = null
) : RuntimeException(msg) {
}