package vn.techmaster.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;

import java.util.ArrayList;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query("SELECT t FROM tag AS t WHERE t.id >= 1")
    List<Tag> getAllTag();

//    List<Tag> getAllByPost(Post post);
}
