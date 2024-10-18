package com.eafit.nodo.config;

import com.eafit.nodo.models.empleado.Departamento;
import com.eafit.nodo.models.empleado.Empleado;
import com.eafit.nodo.models.empleado.Pago;
import com.eafit.nodo.models.empleado.Proyecto;
import com.eafit.nodo.models.supermercado.Cliente;
import com.eafit.nodo.models.supermercado.Compra;
import com.eafit.nodo.models.supermercado.Marca;
import com.eafit.nodo.models.supermercado.Producto;
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
    }
}