package repository

class InMemoryKeyValueRepository : KeyValueRepository {
    override fun add(key: String, value: String): Pair<String, String>? {
        return Pair("Hi", "Test")
    }

    override fun find(key: String): String? {
        return "Test"
    }

    override fun find(): Map<String, String> {
        return mapOf("Hi" to "Test")
    }

    override fun delete(key: String): Boolean {
        return true
    }
}