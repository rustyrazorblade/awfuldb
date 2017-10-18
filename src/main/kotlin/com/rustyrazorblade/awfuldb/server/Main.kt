package com.rustyrazorblade.awfuldb.server

import io.grpc.ServerBuilder

fun main(args: Array<String>) {
    println("Starting this awful piece of garbage.")

    val port = 5000

    val server = Server()
    val s = ServerBuilder.forPort(port).addService(server).build()
    var tmp = s.start()

    println("Server started, listening on " + port)
    tmp.awaitTermination()
}