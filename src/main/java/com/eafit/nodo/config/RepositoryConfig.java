package com.eafit.nodo.config;

import com.eafit.nodo.models.supermercado.Cliente;
import com.eafit.nodo.models.supermercado.Compra;
import com.eafit.nodo.models.supermercado.Marca;
import com.eafit.nodo.models.supermercado.Producto;
import com.eafit.nodo.repositories.GenericRepository;

public class RepositoryConfig {
    public static final GenericRepository<Cliente> clienteRepository;
    public static final GenericRepository<Compra> compraRepository;
    public static final GenericRepository<Marca> marcaRepository;
    public static final GenericRepository<Producto> productoRepository;

    static {
        JPAConfig<Cliente> jpaConfigCliente = new JPAConfig<>();
        clienteRepository = new GenericRepository<>(jpaConfigCliente);

        JPAConfig<Compra> jpaConfigCompra = new JPAConfig<>();
        compraRepository = new GenericRepository<>(jpaConfigCompra);

        JPAConfig<Marca> jpaConfigMarca = new JPAConfig<>();
        marcaRepository = new GenericRepository<>(jpaConfigMarca);

        JPAConfig<Producto> jpaConfigProducto = new JPAConfig<>();
        productoRepository = new GenericRepository<>(jpaConfigProducto);
    }
}