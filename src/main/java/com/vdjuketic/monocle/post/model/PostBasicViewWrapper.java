package com.vdjuketic.monocle.post.model;

import java.util.ArrayList;
import java.util.List;

import com.vdjuketic.monocle.post.Post;
import lombok.Data;

@Data
public class PostBasicViewWrapper {
	private List<PostBasicView> posts;

	public static PostBasicViewWrapper of(List<Post> posts) {
		PostBasicViewWrapper wrapper = new PostBasicViewWrapper();
		List<PostBasicView> basicViewList = new ArrayList<>();

		for (Post post: posts) {
			basicViewList.add(PostBasicView.of(post));
		}

		wrapper.setPosts(basicViewList);
		return wrapper;
	}
}
