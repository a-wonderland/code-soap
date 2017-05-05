package com.wonderland.hellosoap;

import javax.xml.ws.Endpoint;

public class HelloSoapPublisher {

	public static void main(String[] args) {
		// creating web service endpoint publisher
		Endpoint.publish("http://localhost:9000/ws/hello-soap", new HelloSoapImpl());
	}

}
