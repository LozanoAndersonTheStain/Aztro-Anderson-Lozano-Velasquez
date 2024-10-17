package com.eafit.nodo;

import com.eafit.nodo.models.supermercado.*;
import com.eafit.nodo.repositories.GenericRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SupermercadoCreator {
    private static final Logger logger = Logger.getLogger(SupermercadoCreator.class.getName());

    public static void createMarcas(GenericRepository<Marca> marcaRepository) {
        logger.info("Creando Marca");
        Marca marca1 = Marca.builder()
                .nombre("Diana")
                .activa(true)
                .paisOrigen("Colombia")
                .urlLogo("https://mercasur.com.co/rails/active_storage/representations/proxy/eyJfcmFpbHMiOnsiZGF0YSI6MTc2MDA3OSwicHVyIjoiYmxvYl9pZCJ9fQ==--d7084c300a59d3285a432e2c5f3068694637b78d/eyJfcmFpbHMiOnsiZGF0YSI6eyJmb3JtYXQiOiJwbmciLCJyZXNpemVfdG9fZml0IjpbODAwLDgwMF19LCJwdXIiOiJ2YXJpYXRpb24ifX0=--cef66509c9cdc75663c0eefd9421db1d2ea4fead/Plantilla%20P%C3%A1gina%20(2).png?locale=es")
                .build();

        Marca marca2 = Marca.builder()
                .nombre("Alpina")
                .activa(true)
                .paisOrigen("Colombia")
                .urlLogo("https://elviejoparisvirtual.com/rails/active_storage/representations/proxy/eyJfcmFpbHMiOnsiZGF0YSI6NTQwOTcyLCJwdXIiOiJibG9iX2lkIn19--cc4db015b48ac26f86a1d3ecf1a581b3907de97f/eyJfcmFpbHMiOnsiZGF0YSI6eyJmb3JtYXQiOiJqcGciLCJyZXNpemVfdG9fZml0IjpbODAwLDgwMF19LCJwdXIiOiJ2YXJpYXRpb24ifX0=--1420d7fd3d20057726f0ef3c0043db24ca0403be/leche-alpina-entera-89896b67-9528-42c7-af25-22b5e116790c.jpg?locale=es")
                .build();

        marcaRepository.create(marca1);
        marcaRepository.create(marca2);
    }

    public static void createProductos(GenericRepository<Producto> productoRepository, GenericRepository<Marca> marcaRepository) {
        logger.info("Creando Productos");
        Marca marca1 = marcaRepository.findById(Marca.class, 1L);
        Marca marca2 = marcaRepository.findById(Marca.class, 2L);

        Producto producto1 = Producto.builder()
                .nombre("Arroz")
                .marca(marca1)
                .cantidad(2)
                .fechaFabricacion(LocalDate.parse("2024-06-10"))
                .fechaVencimiento(LocalDate.parse("2025-06-10"))
                .perecedero(false)
                .codigoBarras("123456789")
                .precio(3500)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Leche")
                .marca(marca2)
                .cantidad(3)
                .fechaFabricacion(LocalDate.parse("2024-01-07"))
                .fechaVencimiento(LocalDate.parse("2024-07-08"))
                .perecedero(true)
                .codigoBarras("987654321")
                .precio(2800)
                .build();

        productoRepository.create(producto1);
        productoRepository.create(producto2);
    }

    public static void createClientes(GenericRepository<Cliente> clienteRepository) {
        logger.info("Creando Clientes");
        Cliente cliente1 = Cliente.builder()
                .nombre("Pelicanger")
                .apellido("Estrada")
                .cedula(1011121314)
                .direccion("Calle BR 123")
                .telefono("455-5657-8795")
                .build();

        Cliente cliente2 = Cliente.builder()
                .nombre("Juan")
                .apellido("Perez")
                .cedula(2021222324)
                .direccion("Calle AR 456")
                .telefono("123-4567-8901")
                .build();

        clienteRepository.create(cliente1);
        clienteRepository.create(cliente2);
    }

    public static  void listClientes(GenericRepository<Cliente> clienteRepository) {
        logger.info("Consultando los clientes registrados");
        List<Cliente> clientes = clienteRepository.findAll(Cliente.class);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("Cliente registrado: " + cliente.getNombre() + " " + cliente.getApellido() + " con cédula " + cliente.getCedula());
        }
    }

    public static void createCompras(GenericRepository<Compra> compraRepository, GenericRepository<Cliente> clienteRepository, GenericRepository<Producto> productoRepository) {
        logger.info("Creando Compras");
        Cliente cliente1 = clienteRepository.findById(Cliente.class, 1L);
        Cliente cliente2 = clienteRepository.findById(Cliente.class, 2L);
        Producto producto1 = productoRepository.findById(Producto.class, 1L);
        Producto producto2 = productoRepository.findById(Producto.class, 2L);

        Compra compra1 = Compra.builder()
                .cliente(cliente1)
                .productos(Arrays.asList(producto1))
                .fecha(LocalDate.now())
                .total(7000)
                .pagado(false)
                .entregado(true)
                .build();

        Compra compra2 = Compra.builder()
                .cliente(cliente2)
                .productos(Arrays.asList(producto2))
                .fecha(LocalDate.now())
                .total(8400)
                .pagado(false)
                .entregado(true)
                .build();

        compraRepository.create(compra1);
        compraRepository.create(compra2);
    }

    public static void listCompras(GenericRepository<Compra> compraRepository) {
        logger.info("Consultando las compras registradas");
        List<Compra> compras = compraRepository.findAll(Compra.class);
        for (Compra compra : compras) {
            System.out.println(compra);
            System.out.println("Compra registrada: " + compra.getCliente().getNombre() + " compró productos por un total de " + compra.getTotal());
        }
    }
}