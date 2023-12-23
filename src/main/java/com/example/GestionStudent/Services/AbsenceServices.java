package com.example.GestionStudent.Services;

import com.example.GestionStudent.Entity.Absence;
import com.example.GestionStudent.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AbsenceServices {
    @Autowired
    private AbsenceRepository  AbsenceRepository;
   public List<Absence> getAll(){
       return this.AbsenceRepository.findAll();

   }
   public String add(Absence A){
       this.AbsenceRepository.save(A);
     return   "saved";

   }
   public String delete(Absence A){
       this.AbsenceRepository.delete(A);
       return "deleted";
   }
   public Absence getOne(Long id){
   return   this.AbsenceRepository.findById(id).get();
   }
}
