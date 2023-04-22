package com.sp.pract.app.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ShipBean;

@Repository
public class RouteDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<RouteBean> q; 
	
	public String addRoute(RouteBean routeBean) 
	{
		if(routeBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(routeBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(routeBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}
	
	public String updateRoute(RouteBean routeBean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(routeBean!=null)
		{
		session.update(routeBean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(routeBean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	
	public String deleteroute(int routeID)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(routeID > 0)
		{
		Query q1=session.createQuery("delete from RouteBean where routeID=:rid");
		q1.setParameter("rid", routeID);
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
	
	public RouteBean viewRouteByrouteid(int routeID )
	{
		RouteBean elBean=new RouteBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<RouteBean> q2=session.createQuery("from RouteBean where routeID =:rid");
	q2.setParameter("rid", routeID);
	 ArrayList<RouteBean> all=(ArrayList<RouteBean>) q2.getResultList();
	for(RouteBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}
	
	public ArrayList<RouteBean> viewRoutes()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from RouteBean");
		return (ArrayList<RouteBean>) q.list();
	}
	
	
}
