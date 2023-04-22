package com.sp.pract.app.dao;

import java.util.ArrayList;
//
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ScheduleBean;
import com.sp.pract.app.bean.ShipBean;



@Repository
public class ScheduleDao {
@Autowired
private SessionFactory sessionFactory;
private Session session;
private Transaction transaction;
private Query<ScheduleBean> q;
@Autowired
private ShipDao sdao;
@Autowired
private RouteDao rdao;

//public String addschedule(ScheduleBean schedulebean,int shipID,int routeID) {
//	ShipBean sb=sdao.viewShipByshipId(shipID);
//	RouteBean rb=rdao.viewRouteByrouteid(routeID);
////	System.out.println("Under Dao "+sb);
////	System.out.println("under dao "+rb);
////	System.out.println("Under Dao "+schedulebean);
//	schedulebean.setRoutebean(rb);
//	schedulebean.setShipbean(sb);
//	if(sb.getShipID()==(shipID)&& rb.getRouteID()==(routeID))
//	{
//	if(schedulebean!=null)	
//	{
//		session=sessionFactory.openSession();
//		transaction=session.beginTransaction();
//		session.save(schedulebean);
//		transaction.commit();
//		session.close();
//		return "SUCCESS";
//	}
//	else if(schedulebean==null)
//	{
//		return "ERROR";
//	}
//	else
//	{
//		return "FAIL";
//	}
//	}
//	return null;
//}
//

public String addSchedule(ScheduleBean schedule) 
{
	if(schedule!=null)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(schedule);
		transaction.commit();
		session.close();
		return "SUCCESS";
	}
	else if(schedule==null)
	{
		return "ERROR";
	}
	else
	{
		return "FAIL";
	}
}




public String deletesechedule(int scheduleID)
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	if(scheduleID>0)
	{
	Query q1=session.createQuery("delete from ScheduleBean where scheduleID=:sdid");
	q1.setParameter("sdid", scheduleID);
	q1.executeUpdate();
transaction.commit();
session.close();
	return "SUCCESS";
	}
	else
	{
		return "FAIL";
	}
}

public ArrayList<ScheduleBean> viewSchedules()
{
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
	q=session.createQuery("from ScheduleBean");
	return (ArrayList<ScheduleBean>) q.list();
}

public ScheduleBean viewScheduleByscheduleid(int scheduleID )
{
	ScheduleBean elBean=new ScheduleBean();
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
Query<ScheduleBean> q2=session.createQuery("from ScheduleBean where scheduleID =:sdid");
q2.setParameter("sdid", scheduleID);
 ArrayList<ScheduleBean> all=(ArrayList<ScheduleBean>) q2.getResultList();
for(ScheduleBean e1:all)
{
	elBean=e1;
}
return elBean;
}


public boolean updateSchedule(ScheduleBean scheduleBean,int shipID,int routeID) {
    boolean isSuccess = true;
    ShipBean sb=sdao.viewShipByshipId(shipID);
	RouteBean rb=rdao.viewRouteByrouteid(routeID);
//	System.out.println("Under Dao "+sb);
//	System.out.println("under dao "+rb);
//	System.out.println("Under Dao "+schedulebean);
	scheduleBean.setRoutebean(rb);
	scheduleBean.setShipbean(sb);
	if(sb.getShipID()==(shipID)&& rb.getRouteID()==(routeID))
	{
    try {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(scheduleBean);
        transaction.commit();
        session.close();
    } catch (Exception e) {
        isSuccess = false;
        e.printStackTrace();
    }
	}
    return isSuccess;
}

public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, int routeID)
{

	RouteBean rb=rdao.viewRouteByrouteid(routeID);

	System.out.println(rb);
	ScheduleBean sb=new ScheduleBean();
	sb.setRoutebean(rb);
	if((rb.getSource().equals(source)) && (rb.getDestination().equals(destination)))
	{
	
	session=sessionFactory.openSession();
	transaction=session.beginTransaction();
    Query<ScheduleBean> q2=session.createQuery("from ScheduleBean");
    System.out.println((ArrayList<ScheduleBean>) q2.getResultList());
    return (ArrayList<ScheduleBean>) q2.getResultList();
}
	else {
		System.out.println("error");
	}
	
	return null;
	
}
}
