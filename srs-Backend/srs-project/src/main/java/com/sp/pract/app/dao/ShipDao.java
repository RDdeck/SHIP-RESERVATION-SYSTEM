package com.sp.pract.app.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.pract.app.bean.CredentialsBean;
import com.sp.pract.app.bean.ShipBean;


@Repository
public class ShipDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query<ShipBean> q; 
	
	public boolean authenticate(CredentialsBean user) 
	{
		System.out.println("Under Dao "+user.getUserID()+" "+user.getPassword());
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q3=session.createQuery("from CredentialsBean where userID=:uid and password=:pss");
		q3.setParameter("uid", user.getUserID());
		q3.setParameter("pss", user.getPassword());
		ArrayList<CredentialsBean> al=(ArrayList<CredentialsBean>) q3.getResultList();
		int count=0;
		for(CredentialsBean cb:al)
		{
//			if((cb.getUserID().equals(user.getUserID()))&&(cb.getPassword().equals(user.getPassword())))
//			{
				System.out.println("Record is  present"+cb.getUserID()+" "+cb.getPassword());
				count++;
			}
				if(count>0)
				{
		return true;
				}
				else
				{
					return false;
				}
		}
	
	public String addShip(ShipBean shipBean) 
	{
		
		if(shipBean!=null)
		{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(shipBean);
			transaction.commit();
			session.close();
			return "SUCCESS";
		}
		else if(shipBean==null)
		{
			return "ERROR";
		}
		else
		{
			return "FAIL";
		}
	}

	
	public String updateShip(ShipBean shipBean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(shipBean!=null)
		{
		session.update(shipBean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(shipBean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}
	
	public ShipBean viewShipByshipId(int shipID )
	{
		ShipBean elBean=new ShipBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<ShipBean> q2=session.createQuery("from ShipBean where shipID =:sid");
	q2.setParameter("sid", shipID);
	 ArrayList<ShipBean> all=(ArrayList<ShipBean>) q2.getResultList();
	for(ShipBean e1:all)
	{
		elBean=e1;
	}
	return elBean;
	}
	
	public String deleteship(int shipID){
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query q=session.createQuery("delete from ShipBean where shipID=:shipID");
		q.setParameter("shipID",shipID);
		q.executeUpdate();
        transaction.commit();
        return "SUCCESS";
	
		
	}
	
	public ArrayList<ShipBean> viewShips()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from ShipBean");
		return (ArrayList<ShipBean>) q.list();
	}
}


