package com.sp.pract.app.bean;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="srs_tbl_passenger")
public class PassengerBean {
	@Id
	private int passengerid;
	@ManyToOne
	@JoinColumn(name="reservationID", referencedColumnName="reservationID")
 private ReservationBean reservationbean;
	@ManyToOne
	@JoinColumn(name="scheduleID", referencedColumnName="scheduleID")
 private ScheduleBean schedulebean;
	private String name;
	private int age;
	private String gender;
	public ReservationBean getReservationbean() {
		return reservationbean;
	}
	public void setReservationbean(ReservationBean reservationbean) {
		this.reservationbean = reservationbean;
	}
	public ScheduleBean getSchedulebean() {
		return schedulebean;
	}
	public void setSchedulebean(ScheduleBean schedulebean) {
		this.schedulebean = schedulebean;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "PassengerBean [reservationbean=" + reservationbean + ", schedulebean=" + schedulebean + ", name=" + name
				+ ", age=" + age + ", gender=" + gender + "]";
	}
}
