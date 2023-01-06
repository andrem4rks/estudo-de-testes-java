package com.example.tdd.services;

import com.example.tdd.entities.Course;
import com.example.tdd.repositories.CourseRepository;
import com.example.tdd.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCourseService {

  private ICourseRepository repository;

  public CreateCourseService(ICourseRepository repository) {
    this.repository = repository;
  }

  public Course execute(Course course) {

    // Validar se o curso existe
    Course existedCourse = this.repository.findByName(course.getName());

    // Se sim - retorna erro
    if(existedCourse != null) {
      throw new Error("Curso jã exite!");
    }

    // Se não - retorna novo curso
    return this.repository.save(course);
  }
}
