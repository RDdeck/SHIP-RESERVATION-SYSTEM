package com.sp.pract.app.bean;

import jakarta.persistence.*;

@Entity
@Table(name="srs_tbl_reservation")
public class ReservationBean {
	@Id
	private String reservationID;
	@ManyToOne
	@JoinColumn(name="scheduleID", referencedColumnName="scheduleID")
	private ScheduleBean schedulebean;
	@ManyToOne
	@JoinColumn(name="userID", referencedColumnName="userID")
	private CredentialsBean credentialsBean ;
	private String bookingDate;
	private String journeyDate;
	private int noOfSeats;
	private double totalFare;
	private String bookingStatus;
	public String getReservationID() {
		return reservationID;
	}
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	public ScheduleBean getSchedulebean() {
		return schedulebean;
	}
	public void setSchedulebean(ScheduleBean schedulebean) {
		this.schedulebean = schedulebean;
	}
	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "ReservationBean [reservationID=" + reservationID + ", schedulebean=" + schedulebean
				+ ", credentialsBean=" + credentialsBean + ", bookingDate=" + bookingDate + ", journeyDate="
				+ journeyDate + ", noOfSeats=" + noOfSeats + ", totalFare=" + totalFare + ", bookingStatus="
				+ bookingStatus + "]";
	}
}
