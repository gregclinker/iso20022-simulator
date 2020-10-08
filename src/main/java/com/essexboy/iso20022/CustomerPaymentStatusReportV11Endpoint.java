package com.essexboy.iso20022;

import iso.std.iso._20022.tech.xsd.pain_002_001.Document;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerPaymentStatusReportV11Endpoint {
    private static final String NAMESPACE_URI = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.11";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Document")
    @ResponsePayload
    public Document processPaymant(@RequestPayload Document request) {
        return request;
    }
}
