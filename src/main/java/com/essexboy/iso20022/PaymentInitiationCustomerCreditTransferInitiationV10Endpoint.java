package com.essexboy.iso20022;

import essexboy.com.iso20022_web_service.Pain001Request;
import essexboy.com.iso20022_web_service.Pain001Response;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentInitiationCustomerCreditTransferInitiationV10Endpoint {
    private static final String NAMESPACE_URI = "http://com.essexboy/iso20022-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Pain001Request")
    @ResponsePayload
    public Pain001Response getCountry(@RequestPayload Pain001Request request) {
        final Pain001Response response = new Pain001Response();
        response.setDocument(request.getDocument());
        return response;
    }
}
