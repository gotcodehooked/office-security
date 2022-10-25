package com.example.controlpointservice.service;

import com.example.grpc.*;
import com.example.controlpointservice.model.EmployeeCardDetail;
import com.netflix.discovery.EurekaClient;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.net.ssl.SSLException;
import java.util.UUID;

@Service
public class CheckCardService {

    @GrpcClient("control-point-service")
    private CardDetailServiceGrpc.CardDetailServiceBlockingStub stub;



    @Autowired
    private EurekaClient client;

    public boolean sendToSecurityService(EmployeeCardDetail ecd) throws SSLException {

        final CardDetailResponse response = stub
                .isAccept(CardDetailRequest.newBuilder()
                        .setUUID(UUID.randomUUID().toString())
                        .setFirstName(ecd.getFistName())
                        .setLastName(ecd.getLastName())
                        .setUserID(ecd.getUserID())
                        .build());
        return response.getAccept();
    }
}
