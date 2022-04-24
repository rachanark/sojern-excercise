package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/version-compare")
public class VersionController {

    @GetMapping
    public String compareVersions(@RequestParam String v1, @RequestParam String v2){
        return v1.compareTo(v2) > 0 ? v1 : v2;
    }
}
