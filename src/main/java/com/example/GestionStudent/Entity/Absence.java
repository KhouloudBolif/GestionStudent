package com.example.GestionStudent.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PublicKey;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "absence")
 public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_absence;
    @Column(name = "jour")
    private String jour;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
}
