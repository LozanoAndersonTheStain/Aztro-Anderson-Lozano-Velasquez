package com.eafit.nodo.models.empleado;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ubicacion;

    @Column(length = 1024, nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Empleado> empleados;
}