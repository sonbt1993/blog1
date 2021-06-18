package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;
import vn.techmaster.blog.repository.TagRepository;

import java.util.List;

@Service
public class TagService implements ITagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> getAllTagOfPost(Post post) {
        return null;
    }

    @Override
    public List<Tag> save(Tag tag) {
        return null;
    }
}
