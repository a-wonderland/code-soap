package com.wonderland.hellosoap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Service Interface with customize targetNamespace
@WebService(targetNamespace = "http://hello-soap/ws")
@SOAPBinding(style = Style.DOCUMENT) //optional
public interface HelloSoap {

	@WebMethod String getHelloSoap(String name);

}
