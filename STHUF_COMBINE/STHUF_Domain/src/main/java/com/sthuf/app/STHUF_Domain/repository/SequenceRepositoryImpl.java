package com.sthuf.app.STHUF_Domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sthuf.app.STHUF_Domain.config.SpringMongoConfig1;
import com.sthuf.app.STHUF_Domain.domain.SequenceID;
import com.sthuf.app.STHUF_Domain.exception.SequenceException;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository{

	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
 
	@Override
	public long getNextSequenceId(String key) throws SequenceException {
 
	  //get sequence id
	  Query query = new Query(Criteria.where("_id").is(key));
 
	  //increase sequence id by 1
	  Update update = new Update();
	  update.inc("seq", 1);
 
	  //return new increased id
	  FindAndModifyOptions options = new FindAndModifyOptions();
	  options.returnNew(true);
 
	  //this is the magic happened.
	  SequenceID seqId = 
            mongoOperation.findAndModify(query, update, options, SequenceID.class);
 
	  //if no id, throws SequenceException
          //optional, just a way to tell user when the sequence id is failed to generate.
	  if (seqId == null) {
		throw new SequenceException("Unable to get sequence id for key : " + key);
	  }
 
	  return seqId.getSeq();
 
	}
}
