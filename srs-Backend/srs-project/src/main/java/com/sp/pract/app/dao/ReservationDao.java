package com.sp.pract.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.ProfileBean;
import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ScheduleBean;
import com.sp.pract.app.bean.ShipBean;

@Repository
public class ReservationDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<ScheduleBean> q;
	@Autowired
	private ScheduleDao sdao;
	@Autowired
	private UserDao udao;
	public String  addReservation(ProfileBean pb) {

		
		if(pb!=null)	
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(pb);
			transaction.commit();
			session.close();
			return "SUCCESS";

		}
				else if(pb==null)
				{
					return "ERROR";
				}
				else
				{
					return "FAIL";
				}
			}
}
