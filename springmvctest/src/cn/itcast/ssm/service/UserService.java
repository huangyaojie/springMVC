package cn.itcast.ssm.service;

import cn.itcast.ssm.po.User;

public interface UserService {
public User findUserById(String  userId) throws Exception;
public User findUserByNameAndPsd(String userName, String userPsd) ;
}
