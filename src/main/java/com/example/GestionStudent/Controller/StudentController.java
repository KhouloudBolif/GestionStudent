package com.example.GestionStudent.Controller;

import com.example.GestionStudent.Entity.Student;
import com.example.GestionStudent.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class StudentController {
    @Autowired
    private StudentService StudentService;
@GetMapping("/Getall")
    public String listStudent(Model model){
    model.addAttribute("students",this.StudentService.getAllStudent());
    return "ListStudent";
}
@GetMapping("/Save/new")
public String SaveStudent(Model model){
    Student E =new Student();
    model.addAttribute("student",E);

    //this.StudentService.save(E);
    return "add_Student";
}
@PostMapping("/Student/Save")
    public String Save(@ModelAttribute("student") Student student){
    this.StudentService.save( student);
    return  "redirect:/Getall";
}
/*@GetMapping("/Delete")
    public String Delete(@ModelAttribute("student") Student student) {
    Optional<Student> U = this.StudentService.getOne(student.getId_student());
    if (U.isPresent()) {
        this.StudentService.delete(U);
        return "redirect:/Getall";
    }

    return "redirect:/Getall";
}*/
    @GetMapping("/Student/Update/{id}")
    public String Update(@PathVariable("id") Long id ,Model model){
        model.addAttribute("student",this.StudentService.getOne(id));
     return "Update_student";

    }
@PostMapping("/Student/{id}")
    public String ChangeStudent(@PathVariable("id") Long id , @ModelAttribute("student") Student student,Model model){
        Student existingStudent= this.StudentService.getOne(id);
        existingStudent.setId_student(id);
    existingStudent.setNom(student.getNom());
    existingStudent.setAge(student.getAge());
    existingStudent.setCNE(student.getCNE());
    existingStudent.setPrenom(student.getPrenom());
    this.StudentService.Update(existingStudent);
    return "redirect:/Getall";
    }
    @GetMapping("/Student/Delete/{id}")
    public String Delete(@PathVariable("id") Long id ,Model model){
      //  model.addAttribute("student",this.StudentService.getOne(id));
       Student U =this.StudentService.getOne(id);
       this.StudentService.delete(U);
        return "redirect:/Getall";

    }
}
