package com.tri.revision.orchild.repository;

import com.tri.revision.orchild.entity.User;
import com.tri.revision.orchild.enums.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsUserByRole(Role role);
    boolean existsByUsername(String username);
    Optional<User> findUserByUsername(String username);
}
