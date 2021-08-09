package com.onlineExam.OnlineQuiz.model;




import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.lang.NonNull;




public class QuestionAndAnswer {
	
	
	
	@NonNull
	@Indexed(unique=true)
	private String question;
	
	@NonNull
	private String answer;
	
	@NonNull
	private String answerOption1;
	
	@NonNull
	private String answerOption2;
	
	@NonNull
	private String answerOption3;
	
	@NonNull
	private String answerOption4;
	
	
	public QuestionAndAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionAndAnswer(String question, String answer, String answerOption1, String answerOption2,
			String answerOption3, String answerOption4) {
		super();
		this.question = question;
		this.answer = answer;
		this.answerOption1 = answerOption1;
		this.answerOption2 = answerOption2;
		this.answerOption3 = answerOption3;
		this.answerOption4 = answerOption4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerOption1() {
		return answerOption1;
	}
	public void setAnswerOption1(String answerOption1) {
		this.answerOption1 = answerOption1;
	}
	public String getAnswerOption2() {
		return answerOption2;
	}
	public void setAnswerOption2(String answerOption2) {
		this.answerOption2 = answerOption2;
	}
	public String getAnswerOption3() {
		return answerOption3;
	}
	public void setAnswerOption3(String answerOption3) {
		this.answerOption3 = answerOption3;
	}
	public String getAnswerOption4() {
		return answerOption4;
	}
	public void setAnswerOption4(String answerOption4) {
		this.answerOption4 = answerOption4;
	}
	@Override
	public String toString() {
		return "QuestionAndAnswer [question=" + question + ", answer=" + answer + ", answerOption1=" + answerOption1
				+ ", answerOption2=" + answerOption2 + ", answerOption3=" + answerOption3 + ", answerOption4="
				+ answerOption4 + "]";
	}

	
	

}
