package com.sp.pract.app.bean;

import jakarta.persistence.*;

@Entity
@Table(name="srs_tbl_schedule")

public class ScheduleBean {
	@Id
	@GeneratedValue
	private int scheduleID ;
	@ManyToOne
	@JoinColumn(name="shipID")

 private ShipBean shipbean;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MyrouteID")
	private RouteBean routebean;
	private String startDate;
	public int getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	public ShipBean getShipbean() {
		return shipbean;
	}
	public void setShipbean(ShipBean shipbean) {
		this.shipbean = shipbean;
	}
	public RouteBean getRoutebean() {
		return routebean;
	}
	public void setRoutebean(RouteBean routebean) {
		this.routebean = routebean;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "ScheduleBean [scheduleID=" + scheduleID + ", shipbean=" + shipbean + ", routebean=" + routebean
				+ ", startDate=" + startDate + "]";
	}
}
