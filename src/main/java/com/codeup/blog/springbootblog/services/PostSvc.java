package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {
    private final PostsRepository postsDao;

    public PostSvc(PostsRepository postDao){
        this.postsDao=postDao;
    }

    public List<Post> findAll() {
        return (List) postsDao.findAll();
    }

    public Post findOne (long id) {
        return postsDao.findOne(id);
    }

    public Post save(Post post) {
        return postsDao.save(post);
    }

    public void createPost(String title, String body) {
        Post post = new Post(title, body);
        postsDao.save(post);
    }

    public void update(Post post){
        postsDao.save(post);
    }

    public void delete (Post post) {
        postsDao.delete(post);
    }
}
