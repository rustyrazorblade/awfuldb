package com.rustyrazorblade.awfuldb.server

import com.google.protobuf.ByteString

class DB {
    private var data : MutableMap<ByteString, ByteString> = HashMap()

    init {
        println("Creating a new DB")
    }

    fun put(key: ByteString, value: ByteString) {
        data.put(key, value)
    }

    fun get(key: ByteString) : ByteString? {
        return data[key]
    }

}