package com.Leadlake.login;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class LoginDaoImplementation implements LoginDao{
	
	
		public static final String LOGIN_COLLECTION = "registration";	 

		static private MongoTemplate mongoTemplate;
		public LoginDaoImplementation(MongoTemplate mongoOps) 
		{
			if(mongoTemplate==null)
			{			
				LoginDaoImplementation.mongoTemplate = mongoOps;
			}
		}
		
		
		public LoginUser readByNameAndPswd(String emailID,String Password)
		{
			emailID=emailID.toLowerCase();

			Query query = new Query(Criteria.where("emailID").is(emailID).andOperator(Criteria.where("password").is(Password)));

			


			LoginUser loginstatus=new LoginUser();   

			LoginUser l1=	mongoTemplate.findOne(query, LoginUser.class, LOGIN_COLLECTION);
			
			
			
			if(l1==null)
			{
				
				System.out.println("false");
				l1.setStatus("false");
				return l1;
			}
			else
			{
				
				System.out.println("true");
				l1.setStatus("true");
				return l1;
			}	      

			
			

		}



	}



