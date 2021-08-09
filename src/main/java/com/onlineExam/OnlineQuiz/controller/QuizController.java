package com.onlineExam.OnlineQuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineExam.OnlineQuiz.repository.QuizRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("quiz/v1")
public class QuizController {
	
	@Autowired
	private QuizRepository quizRepository;
	

}
