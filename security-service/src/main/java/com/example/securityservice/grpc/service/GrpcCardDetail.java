package com.example.securityservice.grpc.service;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GrpcCardDetail extends CardDetailServiceGrpc.CardDetailServiceImplBase {
    @Override
    public void isAccept(EmployeeCardDetail.CardDetailRequest request, StreamObserver<EmployeeCardDetail.CardDetailResponse> responseObserver) {
        System.out.println(request.getUUID());
        System.out.println(request.getFirstName());
        System.out.println(request.getLastName());
        System.out.println(request.getUserID());

        EmployeeCardDetail.CardDetailResponse cardDetailResponse = EmployeeCardDetail.CardDetailResponse.newBuilder().setAccept(true).build();

        responseObserver.onNext(cardDetailResponse);
        responseObserver.onCompleted();
    }
}
