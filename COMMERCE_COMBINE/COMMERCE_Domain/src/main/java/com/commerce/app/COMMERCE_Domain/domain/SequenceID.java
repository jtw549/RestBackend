package com.commerce.app.COMMERCE_Domain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection = "Sequence")
public class SequenceID {
 
	@Id
	private String id;
 
	private long seq;

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}