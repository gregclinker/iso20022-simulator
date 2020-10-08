package com.essexboy.iso20022;

import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
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
public class PainIntegrationTests {

    @LocalServerPort
    private int port = 0;

    @Test
    public void pain001() throws Exception {
        runTest(iso.std.iso._20022.tech.xsd.pain_001_001.Document.class, "/pain.001.001.10_1.xml");
    }

    @Test
    public void pain002() throws Exception {
        runTest(iso.std.iso._20022.tech.xsd.pain_002_001.Document.class, "/pain.002.001.11.xml");
    }

    @Test
    public void pain007() throws Exception {
        runTest(iso.std.iso._20022.tech.xsd.pain_007_001.Document.class, "/pain.007.001.10.xml");
    }

    @Test
    public void pain008() throws Exception {
        runTest(iso.std.iso._20022.tech.xsd.pain_008_001.Document.class, "/pain.008.001.09.xml");
    }

    private <T> void runTest(Class<T> clazz, String testPayLoadFile) throws Exception {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ClassUtils.getPackageName(clazz));
        marshaller.afterPropertiesSet();

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        final T document = (T) marshaller.unmarshal(new StreamSource(getClass().getResourceAsStream(testPayLoadFile)));

        T response = (T) webServiceTemplate.marshalSendAndReceive("http://localhost:" + port + "/ws", document);

        assertThat(response != null);
    }

}
