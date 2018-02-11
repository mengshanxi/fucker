package com.self.fucker.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.self.fucker.dto.LoginUser;
import com.self.fucker.dto.PassChange;
import com.self.fucker.entity.User;
import com.self.fucker.service.UserService;
import com.self.fucker.util.PageList;
import com.self.fucker.util.PageParam;
import com.self.fucker.util.PinyinUtil;

/**
 * 
 * @ClassName: UserController
 * @Description: TODO
 * @author mengshanxi
 * @date 2017年9月13日 下午1:46:14
 *
 */
@Controller
@RequestMapping("/system/*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpServletRequest request;

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public boolean logon(@RequestBody LoginUser user) {
		User res = userService.getUserByUsernameAndPass(user);
		if (null != res) {

			request.getSession().setAttribute("userId", res.getUserId());
			request.getSession().setAttribute("username", res.getUsername());

			return true;
		}
		return false;
	}

	// 新建用户
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public boolean add(@RequestBody User user) {
		user.setPassword("123456");
		return userService.addOrUpdate(user);
	}

	// 检查手机号重复
	@RequestMapping(value = "/user/mobile/{mobile}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkMobile(@PathVariable String mobile) {
		User user = userService.getUserByMobile(mobile);
		return null == user ? false : true;
	}

	// 检查邮箱重复
	@RequestMapping(value = "/user/{email}/email", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkEmail(@PathVariable String email) {
		User user = userService.getUserByEmail(email);
		return null == user ? false : true;
	}

	// 检查用户名重复
	@RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUsername(@PathVariable String username) {
		User user = userService.getUserByUsername(username);
		return null == user ? false : true;
	}

	// 更新用户
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public boolean update(@RequestBody User user) {
		return userService.addOrUpdate(user);
	}

	// 修改密码
	@RequestMapping(value = "/user/password", method = RequestMethod.PUT)
	@ResponseBody
	public boolean changePassword(@RequestBody PassChange passChange) {

		LoginUser user = new LoginUser();
		user.setPassword(passChange.getPassword());
		user.setUsername((String) request.getSession().getAttribute("username"));
		User res = userService.getUserByUsernameAndPass(user);
		if (null == res) {
			return false;
		}
		res.setPassword(passChange.getNewPassword());
		return userService.addOrUpdate(res);
	}

	// 根据ID查找
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}

	// 分页
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public Object getUserPage(@RequestParam(required = false) String username,
			@RequestParam(required = false) String mobile, @RequestBody String jsonStr) {
		PageParam pageParam = new PageParam(jsonStr);
		PageInfo<User> pageInfo = userService.getUserPage(pageParam, username, mobile);
		PageList<User> result = new PageList<User>(pageInfo, "");
		return result;
	}

	// 删除
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable int userId) {
		return userService.delete(userId);
	}

	@RequestMapping(value = "/validation", method = RequestMethod.GET)
	@ResponseBody
	public Object validation() {
		return true;
	}

	@RequestMapping(value = "/getPinyin", method = RequestMethod.GET)
	@ResponseBody
	public String getPinyin(@RequestParam(required = false) String fullname) {
		if (null == fullname || fullname.equals("")) {
			return null;
		}
		String username = PinyinUtil.stringToPinyinDefault(fullname);
		// 从数据库中查询有几个相似的username
		return userService.genUsernameByPinyin(username);
	}

}
