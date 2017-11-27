package com.smart.equip.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * DTO implementation that has general getters and setters for the object 
 * Version: 1.0 
 * @author Johnsy
 */



@Entity(name="tbl_question")
@JsonInclude(Include.NON_EMPTY)
public class Question {

	@Id
	@GeneratedValue
	private Long questionId;
	
	private String question;
	private Long insertTime;
	@Transient
	private String answer;
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Long getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Long insertTime) {
		this.insertTime = insertTime;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
