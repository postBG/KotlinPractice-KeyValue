package service

import repository.KeyValueRepository

class KeyValueStoreService(private val keyValueRepository: KeyValueRepository) {
    fun set(key: String, value: String) : Pair<String, String>? {
        return keyValueRepository.add(key, value)
    }

    fun get(key: String) : String {
        return keyValueRepository.find(key) ?: throw NoSuchElementException("key = $key")
    }

    fun del(key: String) : Boolean {
        return keyValueRepository.delete(key)
    }

    fun expire(key: String, seconds: Int) {

    }
}