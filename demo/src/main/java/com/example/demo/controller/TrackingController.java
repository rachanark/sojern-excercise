package com.example.demo.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController()
public class TrackingController {
    @Autowired
    private ResourceLoader resourceLoader;
    private static final String path = "dog.jpg";

    @GetMapping("ping")
    public ResponseEntity<String> ping(){
        Resource resource = resourceLoader.getResource("classpath:"+path);
        if(!resource.exists()) {
            return new ResponseEntity<>("", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(value = "/image",  produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getImage() {
        try {
            InputStream in = getClass()
                    .getResourceAsStream(path);
            if(in == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(IOUtils.toByteArray(in), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
