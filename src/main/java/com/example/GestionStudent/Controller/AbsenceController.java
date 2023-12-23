package com.example.GestionStudent.Controller;

import com.example.GestionStudent.Entity.Absence;
import com.example.GestionStudent.Entity.Student;
import com.example.GestionStudent.Services.AbsenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AbsenceController {
    @Autowired
    private AbsenceServices AbsenceServices;
    @GetMapping("/GetAbsence")
    public String getAll(Model model){
        model.addAttribute("absences" ,this.AbsenceServices.getAll());
        return "allAbsence";
    }
    @GetMapping("/Absence/add")
    public String FormAdd(Model model){
        Absence A =new Absence();
        model.addAttribute("absence",A);
        return "addAbsence";
    }
    @PostMapping("/added")
    public String add(@ModelAttribute("absence") Absence absence){
        this.AbsenceServices.add(absence);
        return "redirect:/GetAbsence";
    }
    @GetMapping("/Absence/Delete/{id}")
    public String delete(@PathVariable("id") Long id){
    Absence A=this.AbsenceServices.getOne(id);
        this.AbsenceServices.delete(A);
        return "redirect:/GetAbsence";
    }
    @GetMapping("/Update/{id}")
    public String formUpdate(@PathVariable("id") Long id, Model model){
        Absence A=this.AbsenceServices.getOne(id);
        model.addAttribute("absence",A);
        return "UpdateFormAbsence";
    }
    @PostMapping("/Absence/{id}")
    public String UpdatedAbsence(@PathVariable("id") Long id ,@ModelAttribute("absence") Absence newabs, Model model ){
        Absence existinAbsence= this.AbsenceServices.getOne(id);
        existinAbsence.setId_absence(id);
        existinAbsence.setJour(newabs.getJour());
        existinAbsence.setStudent(newabs.getStudent());
        this.AbsenceServices.add(existinAbsence);
        return "redirect:/GetAbsence";
    }
}
