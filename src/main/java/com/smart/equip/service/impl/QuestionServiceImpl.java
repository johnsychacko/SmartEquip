package com.smart.equip.service.impl;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.equip.dao.QuestionDao;
import com.smart.equip.dto.Question;
import com.smart.equip.service.QuestionService;
import com.smart.equip.utils.DBResponse;
import com.smart.equip.utils.Messages;
import com.smart.equip.utils.OpCode;
import com.smart.equip.utils.ServiceResponse;
import com.smart.equip.utils.StringUtils;

/*
 * Implementation of the business logic. 
 * Version: 1.0 
 * @author Johnsy
 */


@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDao questionDao;
	
	public ServiceResponse getQuestion() throws Exception{
		return questionDao.getRandomQuestion();
	}
	
	public ServiceResponse readQuestionById(Question question) throws Exception{
	
		DBResponse dbResponse = questionDao.getQuestionById(question);
		if(dbResponse.getOperationCode()==OpCode.SUCCESS) {
			//Need to check answer here, if answer is correct then success otherwise ERROR 
			Question q = (Question)dbResponse.getData();
			if(q!=null) {
				try {
				String answer = question.getAnswer();
				//String answerarray[] = answer.split(" "); 
				ArrayList<Integer> temp_array = new ArrayList<Integer>();
				
				StringTokenizer st = new StringTokenizer(answer, " ");
				while(st.hasMoreTokens()) {
					
					String word = st.nextToken().trim();
					
					word = word.split(",")[0];
					word.trim();
					if(StringUtils.isNumber(word)) {
						System.out.println("word is : "+word);
						temp_array.add(Integer.parseInt(word));
						}					
				}
				System.out.println(temp_array);
				Integer temp_sum = 0;
				
				Integer sum = temp_array.remove(temp_array.size()-1);
				System.out.println("the sum is : "+sum);
				for(Integer number: temp_array) {
					temp_sum = temp_sum+ number;
				}
				System.out.println("the temp_sum is : "+temp_sum);

				if(sum.intValue() == temp_sum.intValue()) {
					dbResponse.setOperationCode(OpCode.SUCCESS);
					dbResponse.setMessage(Messages.CORRECT_ANSWER);		
				}
				else {
					
					dbResponse.setOperationCode(OpCode.FAIL);
					dbResponse.setMessage(Messages.INCORRECT_ANSWER);		
					
				}	
				}catch(Exception e) {
					dbResponse.setMessage(Messages.INCORRECT_ANSWER);		
					dbResponse.setOperationCode(OpCode.FAIL);
					e.printStackTrace();
				}
			}else {
				dbResponse.setOperationCode(OpCode.FAIL);
				dbResponse.setMessage(Messages.INCORRECT_ANSWER);	
			}		
		}else {
			dbResponse.setMessage(Messages.RECORD_NOT_FOUND);
		}
		return dbResponse;
	}
	
	public ServiceResponse insertQuestion(Question question) throws Exception{
		return questionDao.saveQuestion(question);
	}
	
}
