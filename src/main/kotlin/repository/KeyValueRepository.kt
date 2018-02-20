package repository

interface KeyValueRepository {
    fun add(key: String, value: String) : Pair<String, String>?
    fun find(key: String) : String?
    fun find() : Map<String, String>
    fun delete(key: String) : Boolean
}