package com.rustyrazorblade.awfuldb.client

import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.AwfulServer
import com.rustyrazorblade.awfuldb.AwfulServiceGrpc
import io.grpc.ManagedChannelBuilder
import java.nio.charset.Charset

fun main(args: Array<String>) {
    println("Running the test client.")

    var channel = ManagedChannelBuilder.forAddress("localhost", 5000).usePlaintext(true).build()

    var stub = AwfulServiceGrpc.newBlockingStub(channel)

    val key = ByteString.copyFrom("test", Charset.defaultCharset())
    val value = ByteString.copyFrom("value", Charset.defaultCharset())

    val put = AwfulServer.PutRequest.newBuilder().setKey(key).setValue(value).build()

    println("Putting $key, $value")
    val response = stub.putValue(put)

    println("Done putting, $response")

    val get = AwfulServer.GetRequest.newBuilder().setKey(key).build()
    val response2 = stub.getValue(get)

    println("Get($key): $response2")
}