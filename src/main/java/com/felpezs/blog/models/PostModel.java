package com.felpezs.blog.models;

import com.felpezs.blog.dtos.PostRecordDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;
import java.time.Instant;

@Document("Posts")
@Getter
@Setter
@NoArgsConstructor
public class PostModel {
    @Id
    private String id;
    private String title;
    private String subtitle;
    @CreatedDate
    private Instant createdAt;
    private byte[] data;

    public PostModel(PostRecordDto postRecordDto) throws IOException {

        this.title = postRecordDto.title();
        this.subtitle = postRecordDto.subtitle();
        this.data = postRecordDto.data().getBytes();
    }
}
