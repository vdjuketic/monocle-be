package com.vdjuketic.monocle.user.model;

import java.util.ArrayList;
import java.util.List;

import com.vdjuketic.monocle.user.User;
import lombok.Data;

@Data
public class UserBasicViewWrapper {
	List<UserBasicView> users;

	public static UserBasicViewWrapper of(List<User> users) {
		UserBasicViewWrapper wrapper = new UserBasicViewWrapper();
		List<UserBasicView> basicViewList = new ArrayList<>();

		for (User user: users) {
			basicViewList.add(UserBasicView.of(user));
		}

		wrapper.setUsers(basicViewList);
		return wrapper;
	}
}
