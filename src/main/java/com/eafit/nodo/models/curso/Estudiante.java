package com.eafit.nodo.models.curso;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String edad;

    @Column(nullable = false)
    private String email;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Notas> notas;
}