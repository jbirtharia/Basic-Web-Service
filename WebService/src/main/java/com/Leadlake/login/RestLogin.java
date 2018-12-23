package com.Leadlake.login;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.support.ClassPathXmlApplicationContext;



@Path("account")
public class RestLogin {
	
	
	static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	static LoginDao personDAO=ctx.getBean("LoginDao", LoginDao.class);

		
	@POST
	@PermitAll
	@Path("checklogin")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginUser CheckLogin(@FormParam("user") String user,@FormParam("pass") String pass)
	{
		LoginUser loginStatus = personDAO.readByNameAndPswd(user,pass);
		System.out.println(loginStatus.getEmailID());

		System.out.println("To return");
		
		
		return loginStatus;
		
	}
	
}
