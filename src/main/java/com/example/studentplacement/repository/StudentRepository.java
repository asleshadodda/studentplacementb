package com.example.studentplacement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentplacement.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {

}