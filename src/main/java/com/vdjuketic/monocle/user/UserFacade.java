package com.vdjuketic.monocle.user;

import com.vdjuketic.monocle.user.model.UserBasicView;
import com.vdjuketic.monocle.user.model.UserBasicViewWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {

	private final UserService userService;

	public UserBasicViewWrapper getAllUsers() {
		return UserBasicViewWrapper.of(userService.getAllUsers());
	}

	public UserBasicViewWrapper getFollowers(String id) {
		return UserBasicViewWrapper.of(userService.getUserFollowers(id));
	}

	public UserBasicViewWrapper getFollowing(String id) {
		return UserBasicViewWrapper.of(userService.getUsersByIds(userService.getUserFollowing(id)));
	}

	public UserBasicView getUserBasic(String id) {
		User user = userService.getUser(id);
		return UserBasicView.of(user);
	}
}
