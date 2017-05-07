package com.wonderland.jaxb.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

// Service Interface with customize targetNamespace
@WebService(targetNamespace = "http://hello-soap/ws")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface HelloSoap {

	@WebMethod String getHelloSoap(String name);

}
