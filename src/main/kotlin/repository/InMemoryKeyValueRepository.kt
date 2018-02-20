package repository

import model.KeyValueStore

class InMemoryKeyValueRepository : KeyValueRepository {
    override fun add(key: String, value: String): Pair<String, String> {
        return KeyValueStore.put(key, value)
    }

    override fun find(key: String): String? {
        return KeyValueStore.get(key)
    }

    override fun find(): Map<String, String> {
        return KeyValueStore.toMap()
    }

    override fun delete(key: String): String? {
        return KeyValueStore.del(key)
    }
}