package com.springboot.spark.middleware.springsparkmiddleware.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AnalyticsMain {
  @GetMapping("/")
  public String analyticsMain() {
    return "Welcome to Analytics!";
  }
  
}
