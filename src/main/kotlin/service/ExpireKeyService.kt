package service

import model.KeyValueStore
import java.util.*
import kotlin.concurrent.schedule


object ExpireKeyService {
    fun expire(key: String, seconds: Int) {
        Timer(false).schedule(toMilliSeconds(seconds)) {
            KeyValueStore.expire(key)
            print("$key is expired.")
        }
    }

    private fun toMilliSeconds(seconds: Int): Long {
        return (seconds * 1000).toLong()
    }
}