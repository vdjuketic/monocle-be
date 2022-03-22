package com.vdjuketic.monocle.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vdjuketic.monocle.post.model.PostBasicView;
import com.vdjuketic.monocle.post.model.PostBasicViewWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostFacade {

	private final PostService postService;

	public PostBasicView addNewPost(String poster, String title, String description) {
		return PostBasicView.of(postService.addNewPost(poster, title,
				description));
	}

	public PostBasicView buyPost(String postId, String buyerId) {
		return PostBasicView.of(postService.buyPost(postId, buyerId));
	}

	public PostBasicView getPost(String id) {
		return PostBasicView.of(postService.getPostById(id));
	}

	public PostBasicView likePost(String postId, String userId) {
		return PostBasicView.of(postService.likePost(postId, userId));
	}

	public PostBasicViewWrapper getAllPosts() {
		return PostBasicViewWrapper.of(postService.getAllPosts());
	}

	public PostBasicViewWrapper getPostByTags(Set<String> tags) {
		return PostBasicViewWrapper.of(postService.getPostsByTags(tags));
	}

	public PostBasicViewWrapper getLatestPostsForUser(String id) {
		return PostBasicViewWrapper.of(postService.getLatestPostsForUser(id));
	}
}
