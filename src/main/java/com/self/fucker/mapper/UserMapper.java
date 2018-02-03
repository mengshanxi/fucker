package com.self.fucker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.self.fucker.entity.User;

/**
 * 
 * @ClassName: UserMapper
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 上午11:52:13
 *
 */
@Repository
public interface UserMapper extends BaseMapper<User, Integer> {

	public List<User> getUserList(@Param("username") String username, @Param("mobile") String mobile);

	public User getUserByName(@Param("username") String username);

	public int getCountStartWithUsername(@Param("username") String username);

	public User getUserByUsernameAndPass(@Param("username") String username, @Param("password") String password);

	public User getUserByProps(@Param("email") String email, @Param("mobile") String mobile);

}
