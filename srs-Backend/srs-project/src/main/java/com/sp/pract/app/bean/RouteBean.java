package com.sp.pract.app.bean;
import jakarta.persistence.*;

@Entity
@Table(name="srs_tbl_route")
public class RouteBean {
	@Id
	@GeneratedValue
	private int routeID ;
	@Column
	private String source ;
	@Column
	private String destination ;
	@Column
	private String travelDuration;
	@Column
	private Double fare;
	@ManyToOne
	@JoinColumn(name="ship_fk")
 private ShipBean shipbean;
	
	
	public ShipBean getShipbean() {
		return shipbean;
	}
	public void setShipbean(ShipBean shipbean) {
		this.shipbean = shipbean;
	}
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "RouteBean [routeID=" + routeID + ", source=" + source + ", destination=" + destination
				+ ", travelDuration=" + travelDuration + ", fare=" + fare + ", shipbean=" + shipbean + "]";
	}
}
