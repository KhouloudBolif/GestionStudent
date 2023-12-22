package com.example.GestionStudent.Controller;

import com.example.GestionStudent.Entity.Student;
import com.example.GestionStudent.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    this.StudentService.save(E);
    return "add_Student";
}
@PostMapping("/Save")
    public String Save(@ModelAttribute("student") Student student){
    this.StudentService.save( student);
    return  "redirect:/Getall";
}
}
