package com.sthuf.app.STHUF_WebService.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Privacys implements Serializable{
	
	private int position;
	
	private String formula;
	
	private int userId;
	
	private int privacyId;
	
	private String privacy;
	
	//Is this needed? It is already in users and inventory
	
}
