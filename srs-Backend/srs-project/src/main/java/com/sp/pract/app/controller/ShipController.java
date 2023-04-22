package com.sp.pract.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.pract.app.bean.CredentialsBean;
import com.sp.pract.app.bean.ShipBean;
import com.sp.pract.app.service.ScheduleService;
import com.sp.pract.app.service.ShipService;



@RestController 
@CrossOrigin (origins="http://localhost:3000")
@RequestMapping ("ship")
public class ShipController {
	@Autowired
	private ShipService sserv ;	
	@Autowired
	private ScheduleService  shserv;
	@GetMapping("/selectUser/{userID}/{password}")
	@ResponseBody
	public boolean auth(@PathVariable String userID,@PathVariable String password)
{
//		CredentialsBean cb=new CredentialsBean();
//		cb.setUserID(userID);
//		cb.setPassword(password);
		System.out.println("Under Controller "+userID+" "+password);
		CredentialsBean cb=new CredentialsBean();
		cb.setUserID(userID);
		cb.setPassword(password);
		System.out.println(sserv.authenticate(cb));;
		return sserv.authenticate(cb);
	}
	@PostMapping("/addShip")
	public String meth1(@RequestBody ShipBean sb)
	{
		sserv.addShip(sb);
		return "<h1>Ship Added Successfully</h1>";
	}
	@PostMapping("/updateShip")
	public String meth2(@RequestBody ShipBean sb)
	{
		sserv.updateShip(sb);
		return "<h1>Ship updated Successfully</h1>";
	}
	
	@GetMapping("/viewShips")
	public ArrayList<ShipBean> meth5()
	{
		return sserv.viewShips();
    }
	
	@GetMapping("/viewShipByshipId/{id}")
	public ShipBean meth3(@PathVariable(value="id") int shipID)
	{
		return sserv.viewShipByshipId(shipID);
    }
	
	@DeleteMapping("/deleteship/{id}")
	public String meth4(@PathVariable(value="id") int shipID)
	{
		sserv.deleteship(shipID);
		
		return "<h1>Ship is Deleted!</h1>";
	 
    }

	
}



