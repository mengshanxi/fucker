package com.self.fucker.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

	// TODO
	@RequestMapping(value = "/to_login", method = RequestMethod.GET)
	public String toLogin() {
		return "/login";
	}

	// TODO
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String helloHtml(Model map) {
		/**
		
		((Map) map).put("dialStatus", adminService.isDialServerReady() == true ? "拨测服务正常" : "拨测服务异常");
		((Map) map).put("npvStatus", adminService.isNpvServerReady() == true ? "NPV服务正常" : "NPV服务异常");
		
		List userinfo = new ArrayList();
		userinfo.add("周美玲");
		userinfo.add("32");
		userinfo.add("女");
		userinfo.add("1985");
		userinfo.add("19850014665");
		map.addAttribute("configOverview", userinfo);
		
		List userinfo1 = new ArrayList();
		userinfo1.add("周美玲");
		userinfo1.add("32");
		userinfo1.add("女");
		userinfo1.add("1985");
		userinfo1.add("19850014665");
		map.addAttribute("mongoOverview", userinfo1);
		
		*/

		return "/index";
	}

	/**
	 * 
	* @Title: clear 
	* @Description: 一键清理脏数据
	* @param @return    
	* @return String   
	* @throws
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public String clear() {
		return "/message";
	}

	@RequestMapping(value = "/dialswitch/{received}", method = RequestMethod.GET)
	@ResponseBody
	public String changeDialSwitch(@PathVariable(required = true) boolean received) {
		return "OK";
	}

}