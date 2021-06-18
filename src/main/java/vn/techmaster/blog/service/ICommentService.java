package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;

import java.util.List;

public interface ICommentService {
    List<Comment> getALlCommentOfPost(Post post);
    Comment getCommentById(long id);
    Comment save(Comment comment);
    void removeComment(Comment comment);
}
