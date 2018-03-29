package com.slabs.apps.expensetracker.manager.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.slabs.apps.expensetracker.manager.UserManager;
import com.slabs.apps.expensetracker.vo.User;

@Component
public class UserManagerImpl implements UserManager {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<User> getAllUsers() {

		return null;
	}

	@Override
	public User getUser(String userName) {
		String query = "select username, firstname, lastname, sex, password, email, address, mobile from UserInfo where username = '"
				+ userName + "'";
		User user = template.query(query, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()) {
					user.setUserName(rs.getString(1));
					user.setFirstname(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setPassword(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setAddress(rs.getString(7));
					user.setMobile(rs.getString(8));
				}
				return user;
			}

		});
		return user;
	}

}
