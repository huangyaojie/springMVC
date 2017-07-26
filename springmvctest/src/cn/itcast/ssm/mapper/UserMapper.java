package cn.itcast.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import cn.itcast.ssm.po.User;

public interface UserMapper {

public User findUserById(@Param(value="userId") String  userId) throws Exception;

public User findUserByNameAndPsd(@Param(value="userName")String us,@Param(value="userPsd") String usePsd);

}
