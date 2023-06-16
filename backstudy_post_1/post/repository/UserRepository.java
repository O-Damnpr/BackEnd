package com.dsm.post.repository;

import com.dsm.post.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}