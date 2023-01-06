package com.example.tdd.repositories;

import com.example.tdd.entities.Course;

public interface ICourseRepository {

  public Course findByName(String name);
  public Course save(Course course);

}
