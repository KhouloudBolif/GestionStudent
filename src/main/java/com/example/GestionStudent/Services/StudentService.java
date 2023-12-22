package com.example.GestionStudent.Services;

import com.example.GestionStudent.Entity.Student;
import com.example.GestionStudent.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository  StudentRepository;

    public List<Student> getAllStudent(){
System.out.println(this.StudentRepository.findAll());
     return this.StudentRepository.findAll();
    }

    public String save(Student S){
        this.StudentRepository.save(S);
        return "saved";
    }
    public String delete(Student S){
     this.StudentRepository.delete(S);
return "deleted";

    }
    public Student getOne(Long id){
      return StudentRepository.findById(id).get();

    }
     public Student Update(Student S){
        return this.StudentRepository.save(S);
     }
}
