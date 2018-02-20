package utils

import model.Key

class TimeExpiredException(key: Key) : Exception() {
    init {
        Exception("key $key is expired")
    }
}