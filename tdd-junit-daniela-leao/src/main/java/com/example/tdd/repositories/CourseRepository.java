package com.example.tdd.repositories;

import com.example.tdd.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
  public Course findByName(String name);
}
