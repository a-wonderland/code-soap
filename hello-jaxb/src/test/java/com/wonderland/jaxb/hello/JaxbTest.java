package com.wonderland.jaxb.hello;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JaxbTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// File file = new File("./src/test/output/test0.xml");

	}

	@Test
	public void test0() {
		HelloRequest mockRequest = mock(HelloRequest.class, RETURNS_DEEP_STUBS);
		when(mockRequest.getUserName()).thenReturn("user0");
		when(mockRequest.getRequestCode()).thenReturn(0);

		try {
			// create file
			OutputStream outputStream = new FileOutputStream("./src/test/output/test0.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(HelloRequest.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// create xml output
			XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
			marshaller.marshal(mockRequest, xmlWriter);
			// sysout
			marshaller.marshal(mockRequest, System.out);
			assertNotNull(xmlWriter);

		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

	}

	// unmarshall
	@Test
	public void test1() {

		try {

			File file = new File("./src/test/output/test0.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(HelloRequest.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			HelloRequest helloRequest = (HelloRequest) jaxbUnmarshaller.unmarshal(file);

			assertEquals("user0", helloRequest.getUserName());
			assertEquals(Integer.valueOf(0), helloRequest.getRequestCode());

		} catch (JAXBException e) {
			fail(e.getMessage());
			e.printStackTrace();

		}
	}

	// TODO marshaller with soap
	@Test
	public void test2() {

		try {
			OutputStream outputStream = new FileOutputStream("./src/test/output/test2.xml");
			// create xml output
			XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
			HelloRequest mockRequest = mock(HelloRequest.class, RETURNS_DEEP_STUBS);
			when(mockRequest.getUserName()).thenReturn("test2");
			when(mockRequest.getRequestCode()).thenReturn(2);
			// create schema
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File("./src/test/xsd/hello-soap_ws.xsd"));

			JAXBContext jaxbContext = JAXBContext.newInstance(HelloRequest.class);
			// marshall
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setSchema(schema);

			// write to file
			marshaller.marshal(mockRequest, xmlWriter);

			// sysout
			marshaller.marshal(mockRequest, System.out);
			assertNotNull(xmlWriter);
		} catch (Exception e) {
			// fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
