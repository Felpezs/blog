package com.felpezs.blog.controllers;

import com.felpezs.blog.dtos.PostRecordDto;
import com.felpezs.blog.models.PostModel;
import com.felpezs.blog.repositories.PostRepository;
import com.felpezs.blog.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    public PostService getPostService() {
        return postService;
    }

    final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Object> saveProduct(@Valid @ModelAttribute PostRecordDto postRecordDto){
        var postModel = this.getPostService().insert(postRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postModel);
    }
}
