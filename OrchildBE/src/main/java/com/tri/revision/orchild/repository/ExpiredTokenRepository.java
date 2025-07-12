package com.tri.revision.orchild.repository;

import com.tri.revision.orchild.entity.ExpiredToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiredTokenRepository extends MongoRepository<ExpiredToken, String> {
}
