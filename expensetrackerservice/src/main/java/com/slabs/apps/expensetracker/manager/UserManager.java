package com.slabs.apps.expensetracker.manager;

import java.util.List;

import com.slabs.apps.expensetracker.vo.User;

public interface UserManager {

	public List<User> getAllUsers();

	public User getUser(String userName);

}
