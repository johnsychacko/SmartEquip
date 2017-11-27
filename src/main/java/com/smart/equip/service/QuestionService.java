package com.smart.equip.service;

import com.smart.equip.dto.Question;
import com.smart.equip.utils.ServiceResponse;

/*
 * An interface for business logic
 * Version: 1.0 
 * @author Johnsy
 */


public interface QuestionService {

	public ServiceResponse getQuestion() throws Exception;
	public ServiceResponse readQuestionById(Question question) throws Exception;
	public ServiceResponse insertQuestion(Question question) throws Exception;
	
}
