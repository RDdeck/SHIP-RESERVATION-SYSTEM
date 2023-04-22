package com.sp.pract.app.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.PassengerBean;
import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ScheduleBean;

@Repository

public class PassengerDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<PassengerBean> q; 
	@Autowired
	private ScheduleDao sdao;
	
	public String addPassenger(PassengerBean passengerbean) 
	{
		if(passengerbean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(passengerbean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(passengerbean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public ArrayList<PassengerBean> viewPasengersByShip(int scheduleID){
		
		ScheduleBean sb=sdao.viewScheduleByscheduleid(scheduleID);
		System.out.println(sb);
		PassengerBean pb=new PassengerBean();
		pb.setSchedulebean(sb);
		if(sb.getScheduleID()==(scheduleID))
		{
		
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	    Query<PassengerBean> q2=session.createQuery("from PassengerBean");
	    System.out.println((ArrayList<PassengerBean>) q2.getResultList());
	    return (ArrayList<PassengerBean>) q2.getResultList();
	}
		else {
			System.out.println("error");
		}
		
		return null;
	}
	
	
}
