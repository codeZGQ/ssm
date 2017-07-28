package com.action.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.user.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private IUserService userService;
	private Integer pageSize;
	
	@RequestMapping("/listUser")
	public String listUser(@RequestParam(defaultValue="3") Integer pageSize,ModelMap map){
		this.pageSize = pageSize;
		PageHelper.startPage(1, pageSize);
		List<User> list = userService.listUser();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		map.put("list", list);
		map.put("pageInfo", pageInfo);
		map.put("pageSize", pageSize);
		return "user/list";
	}
	
	@RequestMapping("/selectPage")
	@ResponseBody
	public List<User> selectPage(@RequestParam Integer page){
		PageHelper.startPage(page, pageSize);
		List<User> list = userService.listUser();
		return list;
	}
}
