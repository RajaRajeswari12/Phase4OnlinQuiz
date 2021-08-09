package com.onlineExam.OnlineQuiz.model;




import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.lang.NonNull;




public class QuestionAndAnswer {
	
	
	
	@NonNull
	@Indexed(unique=true)
	private String question;
	
	@NonNull
	private String answer;

	public QuestionAndAnswer( String question, String answer) {
		super();
		
		this.question = question;
		this.answer = answer;
	}

	public QuestionAndAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QuestionAndAnswer [question=" + question + ", answer=" + answer + "]";
	}
	
	
	

}
