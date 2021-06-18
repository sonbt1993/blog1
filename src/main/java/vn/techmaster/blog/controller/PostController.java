package vn.techmaster.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.ICommentService;
import vn.techmaster.blog.service.IPostService;
import vn.techmaster.blog.service.ITagService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {
  @Autowired private IAuthenService authenService;
  @Autowired private IPostService postService;
  @Autowired private ICommentService commentService;
  @Autowired private ITagService tagService;

  @GetMapping("/allpost")
  public String getAllPost(Model model, HttpServletRequest request) {
    model.addAttribute("user", authenService.getUser(request));
    model.addAttribute("posts", postService.getAllPost());
    return "allpost";
  }

  @GetMapping("/posts")
  public String getAllPostOfUser(Model model, HttpServletRequest request) {
    User user = authenService.getUser(request);
    if (user != null) {
      model.addAttribute("user", user);
      model.addAttribute("posts", postService.getAllPostOfUser(authenService.getUser(request)));
      return Route.ALLPOSTS;
    } else {
      return Route.REDIRECT_HOME;
    }
  }

  @GetMapping("/posts/add")
  public String addPost(Model model, HttpServletRequest request) {
    model.addAttribute("post", new Post());
    model.addAttribute("tags", tagService.getAllTag());
    model.addAttribute("user", authenService.getLoginedUser(request));
    return "add";
  }

  @PostMapping("/posts/add")
  public String savePost(@ModelAttribute(name = "post") Post post,
                         HttpServletRequest request) {
    post.setAuthor(authenService.getUser(request));
    postService.addPostIntoUser(post);
    return Route.REDIRECT_POSTS;
  }

  @GetMapping("/posts/{postId}")
  public String showPage(@PathVariable("postId") Long postId,
                         HttpServletRequest request,
                         Model model) {
    if (postId != null) {
      model.addAttribute("comment", new Comment());
      model.addAttribute("user", authenService.getLoginedUser(request));
      model.addAttribute("post", postService.getPostById(postId));
      return "page";
    }
      return Route.REDIRECT_POSTS;
  }

  @GetMapping("/posts/edit")
  public String editPage(@RequestParam(required = false) Long id,
                         Model model, HttpServletRequest request) {
    model.addAttribute("tags", tagService.getAllTag());
    model.addAttribute("post", postService.getPostById(id));
    model.addAttribute("user", authenService.getUser(request));
    return "edit";
  }

  @PostMapping("/posts/{postId}")
  public String savePage(@ModelAttribute(name = "post") Post post, HttpServletRequest request) {
    post.setComments(commentService.getALlCommentOfPost(post));
    post.setAuthor(authenService.getUser(request));
    postService.addPostIntoUser(post);
    return Route.REDIRECT_POSTS+ '/' + post.getId();
  }

  @GetMapping("/posts/delete")
  public String deletePostById(@ModelAttribute(name = "id") Long id) {
    postService.deletePostById(id);
    return Route.REDIRECT_POSTS;
  }
}
