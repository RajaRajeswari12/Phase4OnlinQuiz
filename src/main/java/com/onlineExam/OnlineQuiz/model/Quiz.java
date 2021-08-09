package com.onlineExam.OnlineQuiz.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Quiz")
public class Quiz {

	@Transient
    public static final String SEQUENCE_NAME = "quiz_sequence";
	
	@Id
	private long id;
	
	
	List<QuestionAndAnswer> questionAnswerList;


	public Quiz(long id, List<QuestionAndAnswer> questionAnswerList) {
		super();
		this.id = id;
		this.questionAnswerList = questionAnswerList;
	}


	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<QuestionAndAnswer> getQuestionAnswerList() {
		return questionAnswerList;
	}


	public void setQuestionAnswerList(List<QuestionAndAnswer> questionAnswerList) {
		this.questionAnswerList = questionAnswerList;
	}


	@Override
	public String toString() {
		return "Quiz [id=" + id + ", questionAnswerList=" + questionAnswerList + "]";
	}
	
	
	
	
}
