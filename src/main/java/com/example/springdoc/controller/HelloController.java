package com.example.springdoc.controller;

import com.example.springdoc.model.request.HelloRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Tag(name = "Hello APIs", description = "Hello APIs to greet you")
public class HelloController {

    @Operation(summary = "Greeting", description = "Greet you")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Oops")
    })
    @PostMapping("/v1/greeting")
    public ResponseEntity<String> greeting(@RequestBody HelloRequest helloRequest){
        return new ResponseEntity<>("Good Day "+helloRequest.getName(), HttpStatus.OK);
    }

}
