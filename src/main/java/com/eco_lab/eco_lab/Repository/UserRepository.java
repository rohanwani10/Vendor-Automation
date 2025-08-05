package com.eco_lab.eco_lab.Repository;

import com.eco_lab.eco_lab.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    public User findByEmail(String email);
    public User findByUsername(String username);
}
