package cn.itcast.ssm.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LogManager.getLogger("SystemController");
	//注入mapper
	@Resource
	private UserMapper userMapper;

	@Override
	public User findUserById(String userId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return userMapper.findUserById(userId);
	}

	@Override
	public User findUserByNameAndPsd(String userName, String userPsd) {
		// TODO 自動生成されたメソッド・スタブ
		logger.info("UserServiceImpl调用userMappper的findUserByNameAndPsd"+userName+","+userPsd);
		return  userMapper.findUserByNameAndPsd(userName,userPsd);
	}


}
