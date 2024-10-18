package com.eafit.nodo.services;

import com.eafit.nodo.models.empleado.*;
import com.eafit.nodo.repositories.generics.GenericRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class EmpleadoCreator {
    private static final Logger logger = Logger.getLogger(EmpleadoCreator.class.getName());

    public static void createDepartamentos(GenericRepository<Departamento> departamentoRepository) {
        logger.info("Creando departamentos");
        Departamento departamento1 = Departamento.builder()
                .nombre("Desarrollo de Sofware")
                .ubicacion("Medellín")
                .descripcion("Departamento de desarrollo de software de la empresa")
                .build();

        Departamento departamento2 = Departamento.builder()
                .nombre("Marketing")
                .ubicacion("Medellín")
                .descripcion("Departamento de marketing de la empresa")
                .build();

        departamentoRepository.create(departamento1);
        departamentoRepository.create(departamento2);
    }

    public static void createProyectos(GenericRepository<Proyecto> proyectoRepository) {
        logger.info("Creando proyectos");
        Proyecto proyecto1 = Proyecto.builder()
                .nombre("Pagina Web de Ventas")
                .descripcion("Desarrollo de una pagina web para una distribuidora de prendas de vestir")
                .fechaInicio(LocalDate.parse("2023-01-01"))
                .fechaFin(LocalDate.parse("2023-06-01"))
                .build();

        Proyecto proyecto2 = Proyecto.builder()
                .nombre("Campaña de Marketing")
                .descripcion("Campaña de marketing para la promoción de un nuevo producto")
                .fechaInicio(LocalDate.parse("2023-01-01"))
                .fechaFin(LocalDate.parse("2023-06-01"))
                .build();

        proyectoRepository.create(proyecto1);
        proyectoRepository.create(proyecto2);
    }

    public static List<Empleado> createEmpleados(GenericRepository<Empleado> empleadoRepository,
                                                 GenericRepository<Departamento> departamentoRepository,
                                                 GenericRepository<Proyecto> proyectoRepository) {
        logger.info("Creando empleados");

        // Buscar departamentos y proyectos creados previamente
        Departamento departamento1 = departamentoRepository.findAll(Departamento.class).get(0);
        Proyecto proyecto1 = proyectoRepository.findAll(Proyecto.class).get(0);

        Empleado empleado1 = Empleado.builder()
                .nombre("Camilo")
                .apellido("Castañeda")
                .cedula("123456789")
                .cargo("Desarrollador")
                .email("example@email.com")
                .telefono("656-5878-9568")
                .salario(1300000)
                .cuentaBancaria("123456789")
                .departamento(departamento1)
                .proyecto(proyecto1)
                .build();

        empleadoRepository.create(empleado1);

        return List.of(empleado1);
    }

    public static void createPagos(GenericRepository<Pago> pagoRepository, List<Empleado> empleados) {
        logger.info("Creando pagos");
        Pago pago1 = Pago.builder()
                .monto(1600000)
                .fechaPago(LocalDate.parse("2023-01-01"))
                .empleado(empleados.get(0))
                .descripcionPago("Pago de salario")
                .build();

        pagoRepository.create(pago1);
    }

    public static void listEmpleados(GenericRepository<Empleado> empleadoRepository) {
        logger.info("Listando empleados");
        List<Empleado> empleados = empleadoRepository.findAll(Empleado.class);
        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        }
    }
}