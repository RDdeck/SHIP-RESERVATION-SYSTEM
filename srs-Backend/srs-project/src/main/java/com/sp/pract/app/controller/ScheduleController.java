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
import com.sp.pract.app.service.ScheduleService;

@RestController 
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping ("/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleService sserv;
	
	@PostMapping("/addschedudle")
	public String meth1(@RequestBody ScheduleBean sb)
	{
		sserv.addschedule(sb);
		return "<h1>Schedule Added Successfully</h1>";
	}
	
	@GetMapping("/viewScheduleByscheduleid/{id}")
	public ScheduleBean meth3(@PathVariable(value="id") int scheduleID)
	{
		return sserv.viewScheduleByscheduleid(scheduleID);
    }
	
	@DeleteMapping("/deleteschedule/{id}")
	public String meth4(@PathVariable(value="id") int scheduleID)
	{
		sserv.deletesechedule(scheduleID);
		return "<h1>Schedule is Deleted!</h1>";
	 
    }
	
	@PutMapping("/updateSchedule/{id}/{id1}")
	public boolean meth2(@RequestBody ScheduleBean rb,@PathVariable(value="id") int shipID,@PathVariable(value="id1") int routeID)
	{
	
		System.out.println(rb+""+shipID+""+routeID);
		return sserv.updateSchedule(rb,shipID,routeID);
	}
	@GetMapping("/viewScheduleByRoute/{s}/{des}/{id}")
	public ArrayList<ScheduleBean> meth5(@PathVariable(value="id") int routeID,@PathVariable(value="s") String source,@PathVariable(value="des") String destination)
	{
		return sserv.viewScheduleByRoute(source, destination, routeID);
    }
	@GetMapping("/viewschedule")
	public ArrayList<ScheduleBean> meth5()
	{
		return sserv.viewSchedules();
    }
}