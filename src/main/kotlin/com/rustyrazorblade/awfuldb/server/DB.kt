package com.rustyrazorblade.awfuldb.server

import com.fasterxml.jackson.core.JsonFactory
import java.util.concurrent.ConcurrentHashMap
import java.util.Optional


import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.JsonObject

/*
Database.  So exciting.  Just a K/V store for now
Goals:
 * Add support for complex types via json
 * Add schema with type validation
 * Add indexes
 * improve concurrent access (it's crap now)

 */
class DB {
    private var data : MutableMap<String, JsonNode> = ConcurrentHashMap()
    private var mapper = ObjectMapper()

    init {
        println("Creating a new DB")
    }

    fun put(key: String, value: String) {
        try {
            // validate the JSON
            val tree = mapper.readTree(value)

            val put = data.put(key, tree)
        } catch (e: Exception) {
            println("Meh, fail $e")
        }
    }

    fun get(key: String) : Optional<String> {
        var tmp = data[key]

        if (tmp != null) {
            val str = tmp.toString()
            return Optional.of(str)
        } else {
            return Optional.empty()
        }
    }

}