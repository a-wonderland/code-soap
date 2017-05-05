package com.wonderland.hellosoap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloSoapClient {

	public static void main(String[] args) throws Exception {
		// create wsdl url
		URL wsdlDocumentUrl = new URL("http://localhost:8000/ws/hello-soap?wsdl"); //port changed for TcpMonitorServer
		QName helloSoapService = new QName("http://hello-soap/ws", "HelloSoapService");
		// create web service
		Service service = Service.create(wsdlDocumentUrl, helloSoapService);
		// get object of pointed service port
		HelloSoap helloSoap = service.getPort(HelloSoap.class);
		for (int i = 1; i <= 3; i++) {
			System.out.println(helloSoap.getHelloSoap("Soap " + i));
		}
	}

}
