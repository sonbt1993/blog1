package vn.techmaster.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.ICommentService;
import vn.techmaster.blog.service.IPostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired private IAuthenService authenService;
    @Autowired private IPostService postService;
    @Autowired private ICommentService commentService;

    @PostMapping("/posts/comment/{postId}")
    public String saveComment(@ModelAttribute(name = "comment") Comment comment,
                              @PathVariable("postId") Long postId,
                              HttpServletRequest request) {
        comment.setCommenter(authenService.getUser(request));
        comment.setPost(postService.getPostById(postId));
        commentService.save(comment);
        return Route.REDIRECT_POSTS+ '/' + postId;
    }

    @GetMapping("/posts/remove")
    public String removeComment(@ModelAttribute("commentId") Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        commentService.removeComment(comment);
        return Route.REDIRECT_POSTS+ '/' + comment.getPost().getId();
    }
}
