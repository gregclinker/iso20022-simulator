package com.essexboy.iso20022;

import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentInitiationCustomerCreditTransferInitiationV10Endpoint {
    private static final String NAMESPACE_URI = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.10";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Document")
    @ResponsePayload
    public Document getCountry(@RequestPayload Document request) {
        return request;
    }
}
