package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> getAllTag();
    List<Tag> getAllTagOfPost(Post post);
    List<Tag> save(Tag tag);
}
