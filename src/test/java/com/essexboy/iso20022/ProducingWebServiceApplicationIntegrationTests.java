package com.essexboy.iso20022;

import essexboy.com.iso20022_web_service.Pain001Request;
import essexboy.com.iso20022_web_service.Pain001Response;
import essexboy.com.iso20022_web_service.Pain008Request;
import essexboy.com.iso20022_web_service.Pain008Response;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProducingWebServiceApplicationIntegrationTests {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @LocalServerPort
    private int port = 0;

    @BeforeEach
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(Pain001Request.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void pain001() throws JAXBException {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        final iso.std.iso._20022.tech.xsd.pain_001_001.Document document = ((JAXBElement<iso.std.iso._20022.tech.xsd.pain_001_001.Document>) marshaller.unmarshal(new StreamSource(getClass().getResourceAsStream("/pain.001.001.10_1.xml")))).getValue();
        final Pain001Request request = new Pain001Request();
        request.setDocument(document);

        final Pain001Response response = (Pain001Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);

        assertThat(response != null);
        assertThat(response.getDocument() != null);
    }

    @Test
    public void pain008() throws JAXBException {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        final iso.std.iso._20022.tech.xsd.pain_008_001.Document document = ((JAXBElement<iso.std.iso._20022.tech.xsd.pain_008_001.Document>) marshaller.unmarshal(new StreamSource(getClass().getResourceAsStream("/pain.008.001.09.xml")))).getValue();
        final Pain008Request request = new Pain008Request();
        request.setDocument(document);

        final Pain008Response response = (Pain008Response) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", request);

        assertThat(response != null);
        assertThat(response.getDocument() != null);
    }
}
