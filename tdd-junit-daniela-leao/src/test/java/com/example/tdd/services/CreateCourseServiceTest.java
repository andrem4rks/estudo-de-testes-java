package com.example.tdd.services;

import com.example.tdd.entities.Course;
import com.example.tdd.repositories.CourseInMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CreateCourseServiceTest {

  @Test
  public void should_be_able_to_create_a_new_course() {
    // Criar novo um novo curso

    // Criar table curso (Entidade)
    // ID, drescription, name, workload
    Course course = new Course();
    course.setDescription("Curso_Description_Test");
    course.setName("Curso_Name");
    course.setWorkload(100);

    //Criar um repositorio de curso
    CourseInMemoryRepository repository = new CourseInMemoryRepository();

    // Criar um novo service
    CreateCourseService createCourseService = new CreateCourseService(repository);
    Course createdCourse = createCourseService.execute(course);

    assertNotNull(createdCourse.getId());
  }

}
