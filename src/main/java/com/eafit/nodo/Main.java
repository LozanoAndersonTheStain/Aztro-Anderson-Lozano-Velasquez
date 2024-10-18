package com.eafit.nodo;

import com.eafit.nodo.config.*;

import com.eafit.nodo.services.EmpleadoCreator;
import com.eafit.nodo.models.empleado.*;
import com.eafit.nodo.repositories.generics.GenericRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Cargando la configuración de la base de datos");
            DataBaseConfig.loadDatabaseProperties();

            logger.info("Iniciando la aplicación");

            // Repositories de empleado
            GenericRepository<Departamento> departamentoRepository = RepositoryConfig.departamentoRepository;
            GenericRepository<Proyecto> proyectoRepository = RepositoryConfig.proyectoRepository;
            GenericRepository<Empleado> empleadoRepository = RepositoryConfig.empleadoRepository;
            GenericRepository<Pago> pagoRepository = RepositoryConfig.pagoRepository;

            logger.info("Creando tablas en la base de datos");

            logger.info("Metodos de empleado");
            EmpleadoCreator.createDepartamentos(departamentoRepository);
            EmpleadoCreator.createProyectos(proyectoRepository);
            List<Empleado> empleados = EmpleadoCreator.createEmpleados(empleadoRepository, departamentoRepository, proyectoRepository);
            EmpleadoCreator.createPagos(pagoRepository, empleados);
            EmpleadoCreator.listEmpleados(empleadoRepository);

        } catch (Exception e) {
            logger.severe(e.getMessage());
        } finally {
            JPAConfig.getEntityManagerFactory().close();
            logger.info("Finalizando la aplicación");
        }
    }
}