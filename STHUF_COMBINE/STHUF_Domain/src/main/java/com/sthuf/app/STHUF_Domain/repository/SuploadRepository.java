package com.sthuf.app.STHUF_Domain.repository;

import java.io.File;
import java.io.IOException;

public interface SuploadRepository {

	public String uploadMedia (String imageOrvideo,File file,String filename,long userid, long inventoryid) throws IOException ;
}
