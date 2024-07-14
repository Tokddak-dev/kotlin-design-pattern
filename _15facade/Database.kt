package _15facade

import java.io.FileReader
import java.util.*

class Database {
    companion object {
        fun getProperties(dbname: String): Properties {
            val filename = "./_15facade/$dbname.txt"
            return Properties().also { it.load(FileReader(filename)) }
        }
    }
}