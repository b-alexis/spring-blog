package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.models.UserWithRoles;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UsersRepository users;

    @Autowired
    public UserDetailsLoader(UsersRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found " + username);
        }
        return new UserWithRoles(user, Collections.emptyList());
    }
}
