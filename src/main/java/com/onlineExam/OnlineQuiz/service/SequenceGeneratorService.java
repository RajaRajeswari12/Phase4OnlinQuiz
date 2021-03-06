package com.onlineExam.OnlineQuiz.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.onlineExam.OnlineQuiz.model.DbSequence;


@Service
public class SequenceGeneratorService {
	
	private MongoOperations mongoOperations;
	
	
	 @Autowired
	    public SequenceGeneratorService(MongoOperations mongoOperations) {
	        this.mongoOperations = mongoOperations;
	    }

	    public long generateSequence(String seqName) {

	        DbSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	                new Update().inc("seq",1), options().returnNew(true).upsert(true),
	                DbSequence.class);
	        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ "+counter);
	        return !Objects.isNull(counter) ? counter.getSeq() : 1;

	    }

}
