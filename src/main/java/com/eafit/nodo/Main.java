package com.eafit.nodo;

import com.eafit.nodo.config.*;
import com.eafit.nodo.models.curso.*;
import com.eafit.nodo.repositories.generics.GenericRepository;
import com.eafit.nodo.services.CursoCreator;
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

            // Repositories de curso
            GenericRepository<Curso> cursoRepository = RepositoryConfig.cursoRepository;
            GenericRepository<Estudiante> estudianteRepository = RepositoryConfig.estudianteRepository;
            GenericRepository<Notas> notasRepository = RepositoryConfig.notasRepository;
            GenericRepository<Profesor> profesorRepository = RepositoryConfig.profesorRepository;

            logger.info("Creando tablas en la base de datos");

            logger.info("Metodos de creacion de cursos");
            CursoCreator.createProfesores(profesorRepository);
            CursoCreator.listarProfesores(profesorRepository);

        } catch (Exception e) {
            logger.severe("Error occurred: " + e.getMessage());
        } finally {
            JPAConfig.getEntityManagerFactory().close();
            logger.info("Finalizando la aplicación");
        }
    }
}