package com.felpezs.blog.repositories;

import com.felpezs.blog.models.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostModel, String> {
}
