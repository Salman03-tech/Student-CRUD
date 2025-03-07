package com.student.student.controller;

import com.student.student.entity.Student;
import com.student.student.repository.StudentRepository;
import com.student.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/create/new-student")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(
            @RequestBody Student student
    ){
        studentService.saveStudent(student);
    }



    // get all students from DB
    @GetMapping("/list-students")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @GetMapping("/student/id/{id}")
    public Student getStudentById(
            @PathVariable Long id
    ){
        Student student = studentService.getStudentDetaislById(id);
        return student;
    }

    @PutMapping("/update/student/id/{id}")
    public Student updateStudentById(
            @PathVariable long id,
            @RequestBody Student updatedStudent
    ){
        Student student = studentService.updateStudent(id, updatedStudent);
        return student;
    }

    @DeleteMapping("/delete/student/id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteStudent(
            @PathVariable long id
    ){
        studentService.deleteStudent(id);
    }
}
