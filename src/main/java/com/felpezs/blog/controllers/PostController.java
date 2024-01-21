package com.felpezs.blog.controllers;

import com.felpezs.blog.dtos.PostRecordDto;
import com.felpezs.blog.models.PostModel;
import com.felpezs.blog.repositories.PostRepository;
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

    @Autowired
    PostRepository postRepository;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Object> saveProduct(@Valid @ModelAttribute PostRecordDto postRecordDto){
        var postModel = new PostModel();

        try{
            postModel.setTitle(postRecordDto.title());
            postModel.setSubtitle(postRecordDto.subtitle());
            postModel.setData(postRecordDto.data().getBytes());

            return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(postModel));
        }catch (IOException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when writing the file.");
        }
    }
}
