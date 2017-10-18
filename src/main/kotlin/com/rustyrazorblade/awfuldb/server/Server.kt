package com.rustyrazorblade.awfuldb.server

import com.rustyrazorblade.awfuldb.AwfulServer
import com.rustyrazorblade.awfuldb.AwfulServer.PutResponse
import com.rustyrazorblade.awfuldb.AwfulServiceGrpc
import io.grpc.stub.StreamObserver

class Server : AwfulServiceGrpc.AwfulServiceImplBase() {
    private var db = DB()

    override fun putValue(request: AwfulServer.PutRequest?, responseObserver: StreamObserver<PutResponse>?) {

        var success = false

        if (request?.key != null && request.value != null) {
            db.put(request.key, request.value)
            success = true
        }

        val response = PutResponse.newBuilder().setSuccess(success).build()
        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun getValue(request: AwfulServer.GetRequest?, responseObserver: StreamObserver<AwfulServer.GetResponse>?) {
        val response = AwfulServer.GetResponse.newBuilder()

        val key = request?.key

        if(key != null) {
            val value = db.get(key)

            if(value != null) {
                println("data found")
                response.value = value
            } else {
            }
            responseObserver?.onNext(response.build())
        }
        responseObserver?.onCompleted()
    }
}