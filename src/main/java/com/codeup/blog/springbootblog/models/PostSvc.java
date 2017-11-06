package com.codeup.blog.springbootblog.models;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSvc {
    private List<Post> posts;

    public PostSvc(){
        createPost();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId(posts.size()+1);
                posts.add(post);
                return post;
    }
    public Post fineOne(long id){
        return posts.get((int)(id-1));
    }
    private void createPost(){

    }
}
