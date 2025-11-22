package com.person.login.repository.client;

import com.person.login.repository.orm.UserOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryWithMongodb extends MongoRepository<UserOrm, String> {
    Optional<UserOrm> findByUsername(String username);
}
