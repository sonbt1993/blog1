package vn.techmaster.blog.service;

import java.util.List;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;

public interface IPostService {
  List<Post> getAllPost();
  List<Post> getAllPostOfUser(User user);
  Post getPostById(long id);
  void addPostIntoUser(Post post);
  Post editPostById(long id);
  void deletePostById(long id);
}
