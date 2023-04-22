package com.sp.pract.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.pract.app.bean.PassengerBean;
import com.sp.pract.app.bean.ProfileBean;
import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.service.PassengerService;
import com.sp.pract.app.service.RouteService;

@RestController 
@CrossOrigin ("http://localhost:3000")
@RequestMapping ("passenger")
public class PassengerController {
	@Autowired
	private PassengerService pserv ;
	
	
	@PostMapping("/addProfile")
	public String meth1(@RequestBody ProfileBean pb)
	{
		pserv.addReservation(pb);
		return "<h1>Passenger Added Successfully</h1>";
	}
	@GetMapping ("/viewPassengerBySchedule/{id}")
	public ArrayList<PassengerBean> meth2(@PathVariable (value="id") int scheduleID) {
		return pserv.viewPasengersByShip(scheduleID);
		
	}
}
