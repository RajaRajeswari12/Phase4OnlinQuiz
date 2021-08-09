package com.onlineExam.OnlineQuiz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineExam.OnlineQuiz.exception.ResourceNotFoundException;
import com.onlineExam.OnlineQuiz.model.QuestionAndAnswer;
import com.onlineExam.OnlineQuiz.model.Quiz;
import com.onlineExam.OnlineQuiz.repository.QuizRepository;
import com.onlineExam.OnlineQuiz.service.QuizService;
import com.onlineExam.OnlineQuiz.service.SequenceGeneratorService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("quiz/v1")
public class QuizController {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private QuizService quizService;

	@GetMapping("/onlineQuiz/{id}")
	public ResponseEntity<Quiz> getOnlineQuizById(@PathVariable(value="id") Long quizId) 
			throws ResourceNotFoundException{
		Quiz quiz  = quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));
		return ResponseEntity.ok().body(quiz);
	}

	@PostMapping("/onlineQuiz")
	public Quiz createQuiz(@Validated @RequestBody Quiz quiz) {
		quiz.setId(sequenceGeneratorService.generateSequence(Quiz.SEQUENCE_NAME));
		return quizRepository.save(quiz);
	}

	@DeleteMapping("/onlineQuiz/{id}")
	public Map<String, Boolean> deleteQuiz(@PathVariable(value="id") Long quizId)
			throws ResourceNotFoundException{
		Quiz quiz =  quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));
		quizRepository.delete(quiz);
		Map<String,Boolean> result = new HashMap<>();
		result.put("Deleted", Boolean.TRUE);
		return result;
	}

	@PutMapping("/onlineQuiz/{id}")
	public Map<Float,Integer> reviewQuiz(@PathVariable(value="id") Long quizId,@Validated @RequestBody Quiz quizWithAnswer)
			throws ResourceNotFoundException{
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException("Quiz Not Found"));
		float mark = quizService.reviewResult(quiz, quizWithAnswer);
		
		Map<Float,Integer> reviewResult = new HashMap<>();
		reviewResult.put(mark, quiz.getQuestionAnswerList().size());
		return reviewResult;
	}


}
