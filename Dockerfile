FROM python:2.7.14

RUN apt-get update

RUN pip install grpcio-tools

# python -m grpc_tools.protoc -I../../protos --python_out=. --grpc_python_out=. ../../protos/route_guide.proto

CMD python -m grpc_tools.protoc -I../../protos --python_out=/root/build/ --grpc_python_out=/root/build/ /root/proto/AwfulServer.proto
