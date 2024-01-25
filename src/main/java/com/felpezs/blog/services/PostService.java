package com.felpezs.blog.services;

import com.felpezs.blog.dtos.PostRecordDto;
import com.felpezs.blog.exceptions.FileException;
import com.felpezs.blog.models.PostModel;
import com.felpezs.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PostService {

    final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostModel insert(PostRecordDto postRecordDto){
        try{
            var postModel = new PostModel(postRecordDto);
            return postRepository.save(postModel);
        }catch(IOException e){
            throw new FileException("");
        }
    }
}
