package vn.techmaster.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;

@Service
public class PostService implements IPostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  @Override
  public List<Post> getAllPostOfUser(User user) {
    // TODO Auto-generated method stub
    return postRepository.findByAuthor(user);
  }

  @Override
  public Post getPostById(long id) {
    Optional<Post> post = postRepository.findById(id);
    return post.orElse(null);
  }

  @Override
  public void addPostIntoUser(Post post) {
    postRepository.save(post);
  }

  @Override
  public Post editPostById(long id) {
    return postRepository.findById(id).get();
  }

  @Override
  public void deletePostById(long id) {
    postRepository.deleteById(id);
  }

}
