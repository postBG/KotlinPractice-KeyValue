package service

import repository.KeyValueRepository

class KeyValueStoreService(private val keyValueRepository: KeyValueRepository, private val expireKeyService: ExpireKeyService) {
    fun set(key: String, value: String) : Pair<String, String>? {
        return keyValueRepository.add(key, value)
    }

    fun get(key: String) : String? {
        return keyValueRepository.find(key)
    }

    fun del(key: String) : String? {
        return keyValueRepository.delete(key)
    }

    fun expire(key: String, seconds: Int) {
        expireKeyService.expire(key, seconds)
    }
}