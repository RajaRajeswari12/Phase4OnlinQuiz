package com.onlineExam.OnlineQuiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineExam.OnlineQuiz.model.QuestionAndAnswer;
import com.onlineExam.OnlineQuiz.model.Quiz;

@Service
public class QuizService {

	
	public float reviewResult(Quiz quizFromDB,Quiz quizFromUser) {
		System.out.println("INSIDE REVIEW RESULT");
		float mark = 0l;
		
		List<QuestionAndAnswer> qaDBList = quizFromDB.getQuestionAnswerList();
		List<QuestionAndAnswer> qaUserList = quizFromUser.getQuestionAnswerList();
		for(int index=0;index< qaDBList.size();index++) {
			QuestionAndAnswer qaDB = qaDBList.get(index);
			QuestionAndAnswer qaUser = qaUserList.get(index);
			if(qaDB.getAnswer().equals(qaUser.getAnswer())) {
				mark++;
			}
		}
		System.out.println("END OF REVIEW RESULT" + mark);
		return mark;
		
	}
}
