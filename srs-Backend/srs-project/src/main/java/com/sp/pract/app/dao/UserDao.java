package com.sp.pract.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.CredentialsBean;
import com.sp.pract.app.bean.RouteBean;
@Repository 
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<CredentialsBean> q; 
	
	public String addUser(CredentialsBean  credentialBean) 
	{
		if(credentialBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(credentialBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(credentialBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	

}
