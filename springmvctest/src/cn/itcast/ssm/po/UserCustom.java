package cn.itcast.ssm.po;

public class UserCustom extends  User {
private boolean autoLogin;
private String binaryCode;
public boolean isAutoLogin() {
	return autoLogin;
}
public void setAutoLogin(boolean autoLogin) {
	this.autoLogin = autoLogin;
}
public String getBinaryCode() {
	return binaryCode;
}
public void setBinaryCode(String binaryCode) {
	this.binaryCode = binaryCode;
}
}
