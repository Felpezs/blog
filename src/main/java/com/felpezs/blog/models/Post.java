package com.felpezs.blog.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document("post")
@Getter
@Setter
public class Post {
    @Id
    private UUID id;
    private String title;
    private String subtitle;
    private String author;
    private Instant createdAt;
    public byte[] file;
}
