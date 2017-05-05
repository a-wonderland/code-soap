package com.wonderland.hellosoap;

import javax.jws.WebService;

// Customized Service Implementation (portName,serviceName,targetNamespace are optional)

@WebService(portName = "HelloSoapPort", serviceName = "HelloSoapService",
endpointInterface = "com.wonderland.hellosoap.HelloSoap", targetNamespace = "http://hello-soap/ws")
public class HelloSoapImpl implements HelloSoap {

	@Override
	public String getHelloSoap(String name) {
		return "[JAX-WS] Hello : " + name;
	}

}
