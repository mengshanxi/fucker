package com.self.fucker.service;

import com.github.pagehelper.PageInfo;
import com.self.fucker.dto.LoginUser;
import com.self.fucker.entity.User;
import com.self.fucker.util.PageParam;

/**
 * 
 * @ClassName: UserService
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 上午11:55:29
 *
 */

public interface UserService {

	public User getUserById(Integer userId);

	public String genUsernameByPinyin(String username);

	public User getUserByMobile(String mobile);

	public User getUserByEmail(String email);

	public User getUserByUsername(String username);

	public User getUserByUsernameAndPass(LoginUser user);

	public boolean addOrUpdate(User user);

	public boolean delete(Integer userId);

	public PageInfo<User> getUserPage(PageParam pageParam, String userName, String mobile);

}
