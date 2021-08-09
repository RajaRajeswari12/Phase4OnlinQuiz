package com.onlineExam.OnlineQuiz.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineExam.OnlineQuiz.OnlineQuizApplication;
import com.onlineExam.OnlineQuiz.model.QuestionAndAnswer;
import com.onlineExam.OnlineQuiz.model.Quiz;






@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineQuizApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class QuizControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	

	private String getRootUrl() {
		return "http://localhost:8182/quiz/v1";
	}

	
	@Test
	public void testCreateQuiz() {
		QuestionAndAnswer qa1 = new QuestionAndAnswer();
		qa1.setQuestion("What is ur name");
		qa1.setAnswerOption1("Raji");
		qa1.setAnswerOption2("KB");
		qa1.setAnswerOption3("Raji1");
		qa1.setAnswerOption4("Raji2");
		qa1.setAnswer("Raji");
		QuestionAndAnswer qa2 = new QuestionAndAnswer();
		qa2.setQuestion("What is ur qualification");
		qa2.setAnswerOption1("BE");
		qa2.setAnswerOption2("BTECH");
		qa2.setAnswerOption3("BSC");
		qa2.setAnswerOption4("MSC");
		qa2.setAnswer("BTECH");
		QuestionAndAnswer qa3 = new QuestionAndAnswer();
		qa3.setQuestion("What is ur age");
		qa3.setAnswerOption1("35");
		qa3.setAnswerOption2("32");
		qa3.setAnswerOption3("33");
		qa3.setAnswerOption4("36");
		qa3.setAnswer("35");
		Quiz quiz = new Quiz();
		List<QuestionAndAnswer> qaList = new ArrayList<>();
		qaList.add(qa1);
		qaList.add(qa2);
		qaList.add(qa3);
		quiz.setQuestionAnswerList(qaList);
		
		ResponseEntity<Quiz> postQuiz = restTemplate.postForEntity(getRootUrl()+"/onlineQuiz", quiz, Quiz.class);
		assertNotNull(postQuiz);
		assertNotNull(postQuiz.getBody());
	}
	
	
	

}
