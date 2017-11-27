package com.smart.equip.dao;

import com.smart.equip.dto.Question;
import com.smart.equip.utils.DBResponse;

/*
 * DAO provides an abstract interface to the MySql Database
 * Version: 1.0 
 * @author Johnsy
 */


public interface QuestionDao {

	public DBResponse getRandomQuestion() throws Exception;
	public DBResponse getQuestionById(Question question) throws Exception;
	public DBResponse saveQuestion(Question question) throws Exception;
	
}
