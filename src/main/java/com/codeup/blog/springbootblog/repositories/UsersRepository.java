package com.codeup.blog.springbootblog.repositories;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <BIConversion.User,Long> {
}
