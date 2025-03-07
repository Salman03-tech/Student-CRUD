package com.student.student.service;

import com.student.student.entity.Student;
import com.student.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public Student getStudentDetaislById(Long id){
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public Student updateStudent(long id, Student updatedStudent){
        Optional<Student> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            Student student = byId.get();
        student.setRollNo(updatedStudent.getRollNo());
        student.setName(updatedStudent.getName());
        student.setPercentage(updatedStudent.getPercentage());
        student.setBranch(updatedStudent.getBranch());
        return studentRepository.save(student);
    }
        return null;
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
