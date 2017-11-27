package com.smart.equip.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.smart.equip.dto.Question;
import com.smart.equip.service.QuestionService;
import com.smart.equip.utils.Messages;
import com.smart.equip.utils.OpCode;
import com.smart.equip.utils.ServiceResponse;
import com.smart.equip.utils.WebResponse;
/*
 * Controller class for this application 
 * Version: 1.0 
 * @author Johnsy
 */
@RestController
public class IQController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/user/client", method = RequestMethod.GET)
	@ResponseBody
	public WebResponse getQuestion() {
		WebResponse response = new WebResponse();
		try {
			ServiceResponse serviceResponse = questionService.getQuestion();
			if(serviceResponse.getOperationCode()==OpCode.SUCCESS) {
				response.setOperationCode(OpCode.SUCCESS);
				response.setMessage(Messages.PLEASE_CHECK_DATA_FIELD);
				response.setDataAvailable(true);
				response.setData(serviceResponse.getData());
			}else {
				response.setOperationCode(OpCode.FAIL);
				response.setMessage(Messages.UNABLE_TO_GET_QUESTION);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setOperationCode(OpCode.EXCEPTION);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/user/client", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object checkAnswer(@RequestBody Question question) {
		WebResponse response = new WebResponse();
		try {			
			response =  questionService.readQuestionById(question);
			if(response.getOperationCode()==OpCode.FAIL) {
				response.setMessage(Messages.INCORRECT_ANSWER);
				//return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).badRequest().body(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setOperationCode(OpCode.EXCEPTION);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
}
