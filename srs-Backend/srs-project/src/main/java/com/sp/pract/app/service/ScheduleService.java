package com.sp.pract.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.pract.app.bean.RouteBean;
import com.sp.pract.app.bean.ScheduleBean;
import com.sp.pract.app.dao.ScheduleDao;

@Service
public class ScheduleService {
@Autowired
private ScheduleDao sdao;

public String addschedule(ScheduleBean schedulebean) {
	return sdao.addSchedule(schedulebean);
}

public ArrayList<ScheduleBean> viewSchedules(){
	return sdao.viewSchedules();
}
public ScheduleBean viewScheduleByscheduleid(int scheduleID ) {
	return sdao.viewScheduleByscheduleid(scheduleID);
}
public String deletesechedule(int routeID) {
	return sdao.deletesechedule(routeID);
}

public boolean updateSchedule(ScheduleBean scheduleBean,int shipID,int routeID) {
	return sdao.updateSchedule(scheduleBean, shipID, routeID);
}
public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, int routeID){
	return sdao.viewScheduleByRoute(source, destination, routeID);
}
}
