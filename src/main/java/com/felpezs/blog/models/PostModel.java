package com.felpezs.blog.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("Posts")
@Getter
@Setter
public class PostModel {
    @Id
    private String id;
    private String title;
    private String subtitle;
    @CreatedDate
    private Instant createdAt;
    private byte[] data;
}
