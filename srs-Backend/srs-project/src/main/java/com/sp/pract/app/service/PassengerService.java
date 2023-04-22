package com.sp.pract.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.pract.app.bean.PassengerBean;
import com.sp.pract.app.bean.ProfileBean;
import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.dao.PassengerDao;
import com.sp.pract.app.dao.ReservationDao;
import com.sp.pract.app.dao.RouteDao;
@Service
public class PassengerService {
@Autowired

private PassengerDao  pdao;
@Autowired
private ReservationDao rdao;

public String addPassenger(PassengerBean passengerbean) {
	return pdao.addPassenger(passengerbean);
}
public ArrayList<PassengerBean> viewPasengersByShip(int scheduleID){
	return pdao.viewPasengersByShip(scheduleID);
}
public String  addReservation(ProfileBean pb) {
	return rdao.addReservation(pb);
	
}
}
