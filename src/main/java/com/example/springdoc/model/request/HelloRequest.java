package com.example.springdoc.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class HelloRequest {

    @Schema(description = "Your name", example = "Joko")
    private String name;

}
