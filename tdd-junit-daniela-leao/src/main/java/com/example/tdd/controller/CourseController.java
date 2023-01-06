package com.example.tdd.controller;

import com.example.tdd.entities.Course;
import com.example.tdd.services.CreateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CreateCourseService createCourseService;

  @PostMapping("/")
  public Course createCourse(@RequestBody Course course) {
    return createCourseService.execute(course);
  }

}
