package com.commerce.app.COMMERCE_Domain.repository;

import com.commerce.app.COMMERCE_Domain.exception.SequenceException;

public interface SequenceRepository {

	long getNextSequenceId(String key) throws SequenceException;
}
