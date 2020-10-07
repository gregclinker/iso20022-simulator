package com.essexboy.iso20022;

import iso.std.iso._20022.tech.xsd.pain_008_001.Document;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentInitiationCustomerDirectDebitInitiationV09EndPoint {
    private static final String NAMESPACE_URI = "urn:iso:std:iso:20022:tech:xsd:pain.008.001.09";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Document")
    @ResponsePayload
    public Document getCountry(@RequestPayload Document request) {
        return request;
    }
}
