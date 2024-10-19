package com.eafit.nodo.config;

import com.eafit.nodo.models.curso.*;
import com.eafit.nodo.models.empleado.*;
import com.eafit.nodo.models.supermercado.*;
import com.eafit.nodo.repositories.generics.GenericRepository;

public class RepositoryConfig {
    //SuperMercado
    public static final GenericRepository<Cliente> clienteRepository;
    public static final GenericRepository<Compra> compraRepository;
    public static final GenericRepository<Marca> marcaRepository;
    public static final GenericRepository<Producto> productoRepository;

    //Empleado
    public static final GenericRepository<Departamento> departamentoRepository;
    public static final GenericRepository<Empleado> empleadoRepository;
    public static final GenericRepository<Pago> pagoRepository;
    public static final GenericRepository<Proyecto> proyectoRepository;

    //Curso
    public static final GenericRepository<Curso> cursoRepository;
    public static final GenericRepository<Estudiante> estudianteRepository;
    public static final GenericRepository<Notas> notasRepository;
    public static final GenericRepository<Profesor> profesorRepository;

    static {
        //SuperMercado
        JPAConfig<Cliente> jpaConfigCliente = new JPAConfig<>();
        clienteRepository = new GenericRepository<>(jpaConfigCliente);

        JPAConfig<Compra> jpaConfigCompra = new JPAConfig<>();
        compraRepository = new GenericRepository<>(jpaConfigCompra);

        JPAConfig<Marca> jpaConfigMarca = new JPAConfig<>();
        marcaRepository = new GenericRepository<>(jpaConfigMarca);

        JPAConfig<Producto> jpaConfigProducto = new JPAConfig<>();
        productoRepository = new GenericRepository<>(jpaConfigProducto);

        //Empleado
        JPAConfig<Departamento> jpaConfigDepartamento = new JPAConfig<>();
        departamentoRepository = new GenericRepository<>(jpaConfigDepartamento);

        JPAConfig<Empleado> jpaConfigEmpleado = new JPAConfig<>();
        empleadoRepository = new GenericRepository<>(jpaConfigEmpleado);

        JPAConfig<Pago> jpaConfigPago = new JPAConfig<>();
        pagoRepository = new GenericRepository<>(jpaConfigPago);

        JPAConfig<Proyecto> jpaConfigProyecto = new JPAConfig<>();
        proyectoRepository = new GenericRepository<>(jpaConfigProyecto);

        //Curso
        JPAConfig<Curso> jpaConfigCurso = new JPAConfig<>();
        cursoRepository = new GenericRepository<>(jpaConfigCurso);

        JPAConfig<Estudiante> jpaConfigEstudiante = new JPAConfig<>();
        estudianteRepository = new GenericRepository<>(jpaConfigEstudiante);

        JPAConfig<Notas> jpaConfigNotas = new JPAConfig<>();
        notasRepository = new GenericRepository<>(jpaConfigNotas);

        JPAConfig<Profesor> jpaConfigProfesor = new JPAConfig<>();
        profesorRepository = new GenericRepository<>(jpaConfigProfesor);
    }
}