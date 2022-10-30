package com.example.securityservice.grpc.service;

import com.example.grpc.*;
import com.example.securityservice.entity.EmployeeCard;
import com.example.securityservice.service.EmployeeCardService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


@GrpcService
public class GrpcCardCheckService extends CardDetailServiceGrpc.CardDetailServiceImplBase {
    @Autowired
    EmployeeCardService employeeCardService;

    @Override
    public void isAccept(EmployeeCardDetail.CardDetailRequest request, StreamObserver<EmployeeCardDetail.CardDetailResponse> responseObserver) {

        AtomicReference<Boolean> isAccess = new AtomicReference<>(false);

        Optional<EmployeeCard> employeeCard = employeeCardService.findById(Long.valueOf(request.getId()));

        System.out.println(employeeCard.get().isActive());
        employeeCard.ifPresent(card -> {
            if (card.isActive()){
                System.out.println(card.isActive());
                isAccess.set(card.isActive());
            }
        });

        System.out.println("isAccess " + isAccess.get());

        EmployeeCardDetail.CardDetailResponse cardDetailResponse = EmployeeCardDetail.CardDetailResponse.newBuilder().setAccept(isAccess.get()).build();

        responseObserver.onNext(cardDetailResponse);
        responseObserver.onCompleted();
    }
}
