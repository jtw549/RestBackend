package com.sthuf.app.STHUF_Domain.repository;

import java.io.IOException;

public interface SdeleteRepository {

	public String deleteMedia (String imageOrvideo,String keyName) throws IOException;
}
