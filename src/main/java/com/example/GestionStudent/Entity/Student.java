package com.example.GestionStudent.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    @Column(name = "nom",nullable = true)
    private String nom ;
    @Column(name = "prenom",nullable = true)
    private String prenom;
    @Column(name = "age",nullable = true)
    private Long age;
    @Column(name = "CNE",nullable = true)
    private String CNE;
@OneToMany(mappedBy = "student")
    private List<Absence> absenceList;

}
