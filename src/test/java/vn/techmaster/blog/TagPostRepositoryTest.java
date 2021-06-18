package vn.techmaster.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.TagRepository;
import vn.techmaster.blog.service.IPostService;
import vn.techmaster.blog.service.ITagService;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@DataJpaTest
public class TagPostRepositoryTest {
    @Autowired private PostRepository postRepository;
    @Autowired private TagRepository tagRepository;

    @Test
    @Transient
    public void contextLoads() {
        Tag tag1 = new Tag("Sport");
        Tag tag2 = new Tag("Music");
        Tag tag3 = new Tag("ESport");

//        postRepository.save(new Post("alo", "1234", new HashSet<Tag>() {
//            {
//                add(tag1);
//                add(tag2);
//            }
//        }));
//        postRepository.save(new Post("blo", "5678", new HashSet<Tag>() {
//            {
//                add(tag1);
//                add(tag3);
//            }
//        }));


    }
}
