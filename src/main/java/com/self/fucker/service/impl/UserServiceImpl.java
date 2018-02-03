package com.self.fucker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.self.fucker.dto.LoginUser;
import com.self.fucker.entity.User;
import com.self.fucker.mapper.UserMapper;
import com.self.fucker.service.UserService;
import com.self.fucker.util.BasePageBean;
import com.self.fucker.util.PageParam;

/**
 * 
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午1:37:43
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public PageInfo<User> getUserPage(PageParam pageParam, String username, String mobile) {
		PageHelper.offsetPage(pageParam.getOffset(), pageParam.getPageSize(), true);
		List<User> list = userMapper.getUserList(username, mobile);
		BasePageBean.addIndexForList(list);
		return new PageInfo<User>(list);
	}

	public User getUserById(Integer userId) {
		return userMapper.getById(userId);
	}

	public String genUsernameByPinyin(String username) {
		int res = userMapper.getCountStartWithUsername(username);
		return username + (res == 0 ? "" : res);
	}

	public boolean addOrUpdate(User user) {
		if (0 == user.getUserId() || ("").equals(user.getUserId())) {
			int res = userMapper.insertSelective(user);
			return res == 1 ? true : false;
		}

		int res = userMapper.updateByPrimaryKeySelective(user);
		return res == 1 ? true : false;

	}

	public boolean delete(Integer userId) {
		int res = userMapper.delete(userId);
		return res == 1 ? true : false;
	}

	public User getUserByUsernameAndPass(LoginUser user) {
		return userMapper.getUserByUsernameAndPass(user.getUsername(), user.getPassword());
	}

	public User getUserByUsername(String username) {
		return userMapper.getUserByProps(username, null);
	}

	public User getUserByMobile(String mobile) {
		return userMapper.getUserByProps(null, mobile);
	}

	public User getUserByEmail(String email) {
		return userMapper.getUserByProps(email, null);
	}

}
