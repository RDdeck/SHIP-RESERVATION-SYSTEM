package com.sp.pract.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ShipBean;
import com.sp.pract.app.dao.RouteDao;
@Service

public class RouteService {
	@Autowired 
	private RouteDao  rdao;
	
	public String addRoute(RouteBean routeBean) {
		return rdao.addRoute(routeBean);
	}
	
	public String updateRoute(RouteBean routeBean) {
		return rdao.updateRoute(routeBean);
	}
	public String deleteroute(int routeID) {
		return rdao.deleteroute(routeID);
	}
	public RouteBean viewRouteByrouteid(int routeID ) {
		return rdao.viewRouteByrouteid(routeID);
	}
	
	public ArrayList<RouteBean> viewRoutes(){
		return rdao.viewRoutes();
	}
	
	
	
	
}



