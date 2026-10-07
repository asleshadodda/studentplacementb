package com.example.studentplacement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentplacement.entity.Student;
import com.example.studentplacement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElse(null);
    }
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYear(student.getYear());
        existingStudent.setCgpa(student.getCgpa());
        existingStudent.setSkills(student.getSkills());
        existingStudent.setPlacementStatus(student.getPlacementStatus());

        return studentRepository.save(existingStudent);
    }
    public boolean deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }
}