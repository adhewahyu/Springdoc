package com.example.springdoc.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Slf4j
public class OpenApiController {

    @Value("classpath:swagger-ui.css")
    private Resource cssFile;

    @GetMapping(value = "/swagger-ui/swagger-ui.css")
    public void resourceCSS(HttpServletRequest request, HttpServletResponse response) {
        setResource(cssFile, response, "text/css;charset=UTF-8");
    }

    private void setResource(Resource resource, HttpServletResponse response, String contentType) {
        try {
            response.setHeader("content-type", contentType);
            response.setHeader("Pragma", "no-cache");
            byte[] file = IOUtils.toByteArray(Objects.requireNonNull(resource.getURI()));
            response.getOutputStream().write(file);
        } catch (Exception e) {
            log.error("Error occurred while loading the OpenAPI CSS file: {}", e.getMessage());
        }
    }

}
