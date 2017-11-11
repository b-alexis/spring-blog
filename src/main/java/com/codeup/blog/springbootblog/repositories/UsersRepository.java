package com.codeup.blog.springbootblog.repositories;

import com.codeup.blog.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <User,Long> {
    public User findByUsername(String username);
}
