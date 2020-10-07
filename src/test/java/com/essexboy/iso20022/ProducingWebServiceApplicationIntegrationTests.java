package com.essexboy.iso20022;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProducingWebServiceApplicationIntegrationTests {

    @LocalServerPort
    private int port = 0;

    @Test
    public void pain001() throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ClassUtils.getPackageName(iso.std.iso._20022.tech.xsd.pain_001_001.Document.class));
        marshaller.afterPropertiesSet();

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        final iso.std.iso._20022.tech.xsd.pain_001_001.Document document = (iso.std.iso._20022.tech.xsd.pain_001_001.Document) marshaller.unmarshal(new StreamSource(getClass().getResourceAsStream("/pain.001.001.10_1.xml")));

        iso.std.iso._20022.tech.xsd.pain_001_001.Document response = (iso.std.iso._20022.tech.xsd.pain_001_001.Document) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", document);

        assertThat(response != null);
    }

    @Test
    public void pain008() throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ClassUtils.getPackageName(iso.std.iso._20022.tech.xsd.pain_008_001.Document.class));
        marshaller.afterPropertiesSet();

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        final iso.std.iso._20022.tech.xsd.pain_008_001.Document document = (iso.std.iso._20022.tech.xsd.pain_008_001.Document) marshaller.unmarshal(new StreamSource(getClass().getResourceAsStream("/pain.008.001.09.xml")));

        iso.std.iso._20022.tech.xsd.pain_008_001.Document response = (iso.std.iso._20022.tech.xsd.pain_008_001.Document) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", document);

        assertThat(response != null);
    }
}
