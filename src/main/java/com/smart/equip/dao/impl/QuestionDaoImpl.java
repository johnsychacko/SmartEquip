package com.smart.equip.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.smart.equip.dao.QuestionDao;
import com.smart.equip.dto.Question;
import com.smart.equip.utils.DBResponse;
import com.smart.equip.utils.Messages;
import com.smart.equip.utils.OpCode;


/*
 * DAO Implementation performs database specific operation in this file
 * Version: 1.0 
 * @author Johnsy
 */


@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public DBResponse getRandomQuestion() throws Exception{
		DBResponse dbResponse = new DBResponse();
		
		Session session = null;
		try {
			Random random = new Random();
			int noOfQ = 2+random.nextInt(3);
			StringBuffer temp = new StringBuffer("");
			for(int i=0;i<noOfQ;i++) {
				int val = random.nextInt(1000);								
				temp.append(val+", ");			
			}
			temp.delete(temp.lastIndexOf(","), temp.length());
			temp.replace(temp.lastIndexOf(","), temp.lastIndexOf(",")+1, " and");	
			
			String q = "Sum of "+temp+" is ?";
			Question question = new Question();
			question.setQuestion(q);
			question.setInsertTime(System.currentTimeMillis());
			
			session = sessionFactory.openSession();
			Transaction tra = session.beginTransaction();
			Long id = (Long)session.save(question);
			tra.commit();
			question.setQuestionId(id);
			
			question.setInsertTime(null);
			dbResponse.setData(question);
			dbResponse.setDataAvailable(true);
			dbResponse.setMessage(Messages.PLEASE_CHECK_DATA_FIELD);
			dbResponse.setOperationCode(OpCode.SUCCESS);	
			
			
//			session = sessionFactory.openSession();
//			String query = "FROM com.smart.equip.dto.Question ORDER BY RAND()";
//			Query q = session.createQuery(query);
//			q.setMaxResults(1);
//			Question qu = (Question)q.uniqueResult();
//			if(qu!=null) {
//				qu.setAnswer(null);
//				qu.setInsertTime(null);
//				dbResponse.setData(qu);
//				dbResponse.setDataAvailable(true);
//				dbResponse.setMessage(Messages.PLEASE_CHECK_DATA_FIELD);
//				dbResponse.setOperationCode(OpCode.SUCCESS);	
//			}					
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return dbResponse;
	}
	
	public DBResponse getQuestionById(Question question) throws Exception{
		DBResponse dbResponse = new DBResponse();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Question q = session.get(Question.class,question.getQuestionId());
			if(q!=null){				
				dbResponse.setData(q);
				dbResponse.setOperationCode(OpCode.SUCCESS);
				dbResponse.setMessage(Messages.PLEASE_CHECK_DATA_FIELD);
			}else {
				dbResponse.setOperationCode(OpCode.FAIL);
				dbResponse.setMessage(Messages.RECORD_NOT_FOUND);
			}			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return dbResponse;		
	}
	
	public DBResponse saveQuestion(Question question) throws Exception{
		DBResponse dbResponse = new DBResponse();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tra = session.beginTransaction();
			session.save(question);
			tra.commit();
		}finally {
			if(session!=null) {
				session.close();
			}
		}		
		return dbResponse;
	}
	
}
