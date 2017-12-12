package com.rustyrazorblade.awfuldb.client

import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.AwfulServer
import com.rustyrazorblade.awfuldb.AwfulServiceGrpc
import io.grpc.ManagedChannelBuilder
import java.nio.charset.Charset


class Client {
    fun connect(address: String, port: Int) {
        var channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext(true).build()
        var stub = AwfulServiceGrpc.newBlockingStub(channel)
    }

    fun put(key: String, value: String) {

    }

    fun get(key: String) {

    }

    fun select(key: String) {

    }

    fun delete(key: String) {
        
    }


}

fun main(args: Array<String>) {
    println("Running the test client.")

    var client = Client()
    client.connect("127.0.0.1", 5000)

    var channel = ManagedChannelBuilder.forAddress("localhost", 5000).usePlaintext(true).build()

    var stub = AwfulServiceGrpc.newBlockingStub(channel)

    val key = "test"
    val value = "{\"key\":\"value\"}"

    val put = AwfulServer.PutRequest.newBuilder().setKey(key).setValue(value).build()

    println("Putting $key, $value")
    val response = stub.putValue(put)

    println("Done putting, $response")

    val get = AwfulServer.GetRequest.newBuilder().setKey(key).build()
    val response2 = stub.getValue(get)

    println("Get($key): $response2")
    if(response2.value == value) {
        println("Got expected value")
    } else {
        println("Something fishy...")
    }


}