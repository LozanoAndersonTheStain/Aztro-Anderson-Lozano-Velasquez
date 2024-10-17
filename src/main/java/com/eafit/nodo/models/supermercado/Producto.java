package com.eafit.nodo.models.supermercado;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private int cantidad;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechaFabricacion;

    @NotNull
    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @NotNull
    @Column(nullable = false)
    private boolean perecedero;

    @Column(nullable = false)
    private String codigoBarras;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @NotNull
    @Positive
    @Column(nullable = false)
    private double precio;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fechaFabricacion=" + fechaFabricacion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", perecedero=" + perecedero +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", marca=" + marca +
                ", precio=" + precio +
                '}';
    }


}