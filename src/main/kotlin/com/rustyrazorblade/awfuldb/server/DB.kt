package com.rustyrazorblade.awfuldb.server

import com.google.protobuf.ByteString
import java.util.concurrent.ConcurrentHashMap
import java.util.Optional


/*
Database.  So exciting.  Just a K/V store for now
Goals:
 * Add support for complex types via json
 * Add schema with type validation
 * Add indexes
 * improve concurrent access (it's crap now)

 */
class DB {
    private var data : MutableMap<ByteString, ByteString> = ConcurrentHashMap()

    init {
        println("Creating a new DB")
    }

    fun put(key: ByteString, value: ByteString) {
        // validate the JSON

        data.put(key, value)
    }

    fun get(key: ByteString) : Optional<ByteString> {
        var tmp = data[key]
        if (tmp != null) {
            return Optional.of(tmp)
        } else {
            return Optional.empty()
        }
    }

}