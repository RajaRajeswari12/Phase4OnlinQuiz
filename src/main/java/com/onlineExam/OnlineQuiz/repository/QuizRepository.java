package com.onlineExam.OnlineQuiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineExam.OnlineQuiz.model.Quiz;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, Long>{

}
