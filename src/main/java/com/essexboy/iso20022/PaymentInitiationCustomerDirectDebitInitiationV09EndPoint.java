package com.essexboy.iso20022;

import essexboy.com.iso20022_web_service.Pain001Response;
import essexboy.com.iso20022_web_service.Pain008Request;
import essexboy.com.iso20022_web_service.Pain008Response;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentInitiationCustomerDirectDebitInitiationV09EndPoint {
    private static final String NAMESPACE_URI = "http://com.essexboy/iso20022-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Pain008Request")
    @ResponsePayload
    public Pain008Response getCountry(@RequestPayload Pain008Request request) {
        final Pain008Response response = new Pain008Response();
        response.setDocument(request.getDocument());
        return response;
    }
}
