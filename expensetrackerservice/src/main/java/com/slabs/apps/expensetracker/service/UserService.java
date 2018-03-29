package com.slabs.apps.expensetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slabs.apps.expensetracker.manager.UserManager;
import com.slabs.apps.expensetracker.vo.User;

@RestController
@RequestMapping("/api/user")
public class UserService {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/getUser", method = { RequestMethod.GET })
	public User getUser(@RequestParam(name = "userName", required = true) String userName) {
		return userManager.getUser(userName);
	}

}
