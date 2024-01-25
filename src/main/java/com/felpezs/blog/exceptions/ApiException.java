package com.felpezs.blog.exceptions;


import java.time.ZonedDateTime;

public record ApiException(String message, ZonedDateTime zonedDateTime) {
}
