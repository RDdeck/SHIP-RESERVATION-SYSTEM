package com.sp.pract.app.bean;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="srs_tbl_credentials")
public class CredentialsBean {
	@Id
	private String userID ;
	@Column
	private String password;
	@Column
	private String userType ;
	@Column
	private int loginStatus;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "CredentialsBean [userID=" + userID + ", password=" + password + ", userType=" + userType
				+ ", loginStatus=" + loginStatus + "]";
	}
	
}
