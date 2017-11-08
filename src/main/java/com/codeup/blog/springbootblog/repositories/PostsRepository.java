package com.codeup.blog.springbootblog.repositories;

import com.codeup.blog.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post,Long>{
}
