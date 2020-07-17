package com.sthuf.app.STHUF_Domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sthuf.app.STHUF_Domain.domain.SocialAccounts;

@Repository
public interface SocialAccountRepository extends MongoRepository<SocialAccounts, String>{

}
