package com.eafit.nodo.config;

import com.eafit.nodo.models.supermercado.Cliente;
import com.eafit.nodo.repositories.GenericRepository;

public class RepositoryConfig {
    public static final GenericRepository<Cliente> clienteRepository;

    static {
        JPAConfig<Cliente> jpaConfigCliente = new JPAConfig<>();
        clienteRepository = new GenericRepository<>(jpaConfigCliente);
    }
}