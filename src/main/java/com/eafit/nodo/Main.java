package com.eafit.nodo;

import com.eafit.nodo.SupermercadoCreator;
import com.eafit.nodo.config.*;
import com.eafit.nodo.models.supermercado.*;
import com.eafit.nodo.repositories.GenericRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Cargando la configuración de la base de datos");
            DataBaseConfig.loadDatabaseProperties();

            logger.info("Iniciando la aplicación");

            GenericRepository<Cliente> clienteRepository = RepositoryConfig.clienteRepository;
            GenericRepository<Producto> productoRepository = RepositoryConfig.productoRepository;
            GenericRepository<Marca> marcaRepository = RepositoryConfig.marcaRepository;
            GenericRepository<Compra> compraRepository = RepositoryConfig.compraRepository;

            logger.info("Creando tablas en la base de datos");

            logger.info("Metodos de supermercado");
            SupermercadoCreator.createMarcas(marcaRepository);
            SupermercadoCreator.createProductos(productoRepository, marcaRepository);
            SupermercadoCreator.createClientes(clienteRepository);
            SupermercadoCreator.listClientes(clienteRepository);
            SupermercadoCreator.createCompras(compraRepository, clienteRepository, productoRepository);
            SupermercadoCreator.listCompras(compraRepository);

        } catch (Exception e) {
            logger.severe(e.getMessage());
        } finally {
            JPAConfig.getEntityManagerFactory().close();
            logger.info("Finalizando la aplicación");
        }
    }
}