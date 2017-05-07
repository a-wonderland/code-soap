package com.wonderland.jaxb.hello;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "HelloSoapService", namespace = "http://hello-soap/ws")
@XmlType(propOrder = { "userName", "requestCode" })
public class HelloRequest {

	private String userName;

	private Integer requestCode;

	@XmlElement(name = "UserName", required = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement(name = "RequestCode", required = true)
	public Integer getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(Integer requestCode) {
		this.requestCode = requestCode;
	}

}
