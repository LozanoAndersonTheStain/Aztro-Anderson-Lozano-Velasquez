package com.eafit.nodo.services;

import com.eafit.nodo.models.curso.Profesor;
import com.eafit.nodo.repositories.generics.GenericRepository;
import java.util.List;
import java.util.logging.Logger;

public class CursoCreator {
    public static final Logger logger = Logger.getLogger(CursoCreator.class.getName());

    public static void createProfesores(GenericRepository<Profesor> profesorRepository) {
        Profesor profesor1 = Profesor.builder()
                .nombre("Pedro")
                .apellido("Cartagena")
                .documento("123456789")
                .email("pedro.cartagena@example.com")
                .build();

        Profesor profesor2 = Profesor.builder()
                .nombre("Danilo")
                .apellido("Cortes")
                .documento("987654321")
                .email("danilo.cortes@example.com")
                .build();

        profesorRepository.create(profesor1);
        profesorRepository.create(profesor2);
    }

    public static void listarProfesores(GenericRepository<Profesor> profesorRepository) {
        logger.info("Listando profesores");
        List<Profesor> profesores = profesorRepository.findAll((Profesor.class));
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
            System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido());
        }
    }
}