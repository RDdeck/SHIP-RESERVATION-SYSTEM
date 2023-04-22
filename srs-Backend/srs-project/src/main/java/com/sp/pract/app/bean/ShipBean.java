package com.sp.pract.app.bean;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="SRS_TBL_SHIP")
public class ShipBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int shipID;
	private  String shipName;
	private  int seatingCapacity;
	private  int reservationCapacity;
	public int getShipID() {
		return shipID;
	}
	public void setShipID(int shipID) {
		this.shipID = shipID;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getReservationCapacity() {
		return reservationCapacity;
	}
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	@Override
	public String toString() {
		return "ShipBean [shipID=" + shipID + ", shipName=" + shipName + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacity=" + reservationCapacity + "]";
	}
}
