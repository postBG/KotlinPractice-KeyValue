package model

import utils.TimeExpiredException


class Key(val key: String, val expired: Boolean = false) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Key

        if (key != other.key) return false

        return true
    }

    override fun hashCode(): Int {
        return key.hashCode()
    }

    override fun toString(): String {
        return key
    }
}

typealias Value = String

object KeyValueStore {
    private val mapOfKey: MutableMap<String, Key> = mutableMapOf()
    private val keyValueMap: MutableMap<Key, Value> = mutableMapOf()

    fun put(_key: String, value: String): Pair<String, String> {
        val key = mapOfKey.getOrDefault(_key, Key(_key))

        if(key.expired){
            throw TimeExpiredException(key)
        }

        mapOfKey.put(_key, key)
        keyValueMap.put(key, value)
        return _key to value
    }

    fun get(_key: String): Value? {
        val key = mapOfKey.getOrDefault(_key, Key(_key))

        if(key.expired) {
            throw TimeExpiredException(key)
        }

        return keyValueMap[key]
    }

    fun del(_key: String): Value? {
        return keyValueMap.remove(mapOfKey[_key])
    }

    fun expire(_key: String) {
        if(mapOfKey.containsKey(_key)){
            mapOfKey.put(_key, Key(_key, true))
        }
    }

    fun toMap(): Map<String, String> {
        return keyValueMap.entries.map { (key, value) -> key.key to value }.toMap()
    }
}

