package com.rustyrazorblade.awfuldb.client

import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.AwfulServer
import com.rustyrazorblade.awfuldb.AwfulServiceGrpc
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.nio.charset.Charset

/*
wrapper around the grpc sillyness
currently takes strings but maybe it would be nicer to take native objects
 */
class Client constructor(address: String, port: Int) {
    var channel: ManagedChannel = ManagedChannelBuilder.forAddress(address, port).usePlaintext(true).build()
    var stub: AwfulServiceGrpc.AwfulServiceBlockingStub = AwfulServiceGrpc.newBlockingStub(channel)

    fun put(key: String, value: String) {
        val put = AwfulServer.PutRequest.newBuilder().setKey(key).setValue(value).build()
    }

    /*
    returns the string response
    should this be a json object?
    not sure
     */
    fun get(key: String) : String {
        val get = AwfulServer.GetRequest.newBuilder().setKey(key).build()
        val response2 = stub.getValue(get)
    }

    fun select(key: String) {

    }

    fun delete(key: String) {

    }


}

fun main(args: Array<String>) {
    println("Running the test client.")

    var client = Client("127.0.0.1", 5000)

    val key = "test"
    val value = "{\"key\":\"value\"}"
    println("Putting $key, $value")

    val response = client.put(key, value)

    println("Done putting, $response")

    val response2 = client.get(key)

    println("Get($key): $response2")

    if(response2 == value) {
        println("Got expected value")
    } else {
        println("Something fishy...")
    }


}