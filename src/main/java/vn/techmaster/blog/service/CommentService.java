package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getALlCommentOfPost(Post post) {
        return commentRepository.findCommentsByPost(post);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.findCommentById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        commentRepository.delete(comment);
    }
}
