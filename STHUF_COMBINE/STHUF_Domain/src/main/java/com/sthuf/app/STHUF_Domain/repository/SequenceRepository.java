package com.sthuf.app.STHUF_Domain.repository;

import com.sthuf.app.STHUF_Domain.exception.SequenceException;

public interface SequenceRepository {

	long getNextSequenceId(String key) throws SequenceException;
}
