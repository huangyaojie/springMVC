package cn.itcast.ssm.po;

import java.util.Date;

public class User {
private  Integer userId;
private  String  userName ;
private String userPsd;
private  String  userGender;
private  Date  userHiredate;
private   Integer userAge;
private String  userJob;
private  Float  userSal;

public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPsd() {
	return userPsd;
}
public void setUserPsd(String userPsd) {
	this.userPsd = userPsd;
}
public String getUserGender() {
	return userGender;
}
public void setUserGender(String userGender) {
	this.userGender = userGender;
}

public Date getUserHiredate() {
	return userHiredate;
}
public void setUserHiredate(Date userHiredate) {
	this.userHiredate = userHiredate;
}
public Integer getUserAge() {
	return userAge;
}
public void setUserAge(Integer userAge) {
	this.userAge = userAge;
}
public String getUserJob() {
	return userJob;
}
public void setUserJob(String userJob) {
	this.userJob = userJob;
}
public Float getUserSal() {
	return userSal;
}
public void setUserSal(Float userSal) {
	this.userSal = userSal;
}

}
