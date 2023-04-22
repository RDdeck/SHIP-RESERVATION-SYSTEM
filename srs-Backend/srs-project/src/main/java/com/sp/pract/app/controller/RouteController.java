package com.sp.pract.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ScheduleBean;
import com.sp.pract.app.bean.ShipBean;
import com.sp.pract.app.service.RouteService;

@RestController 
@CrossOrigin (origins="http://localhost:3000")
@RequestMapping ("route")
public class RouteController {
	@Autowired
	private RouteService rserv ;
	
	@PostMapping("/addroute")
	public String meth1(@RequestBody RouteBean rb)
	{
		rserv.addRoute(rb);
		return "<h1>Schedule Added Successfully</h1>";
	}
	
	@PutMapping("/updateRoute")
	public String meth2(@RequestBody RouteBean rb)
	{
		rserv.updateRoute(rb);
		return "<h1>Route updated Successfully</h1>";
	}
	
	@DeleteMapping("/deleteroute/{id}")
	public String meth4(@PathVariable(value="id") int routeID)
	{
		rserv.deleteroute(routeID);
		return "<h1>Route is Deleted!</h1>";
	 
    }
	
	@GetMapping("/viewRouteByrouteid/{id}")
	public RouteBean meth3(@PathVariable(value="id") int routeID)
	{
		return rserv.viewRouteByrouteid(routeID);
    }
	@GetMapping("/viewRoutes")
	public ArrayList<RouteBean> meth5()
	{
		return rserv.viewRoutes();
    }
	
}

