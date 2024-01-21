package com.felpezs.blog.dtos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record PostRecordDto(@NotBlank String title, String subtitle, @NotBlank MultipartFile data) {
}
