# SupermercadoCreator Documentation

## Description
The `SupermercadoCreator` class provides static methods to create and list entities related to the supermarket, such as `Marca`, `Producto`, `Cliente`, and `Compra`. It uses the `GenericRepository` class to perform CRUD operations.

## Methods

### `createMarcas(GenericRepository<Marca> marcaRepository)`
- **Description**: Creates and saves `Marca` entities.
- **Parameters**:
  - `marcaRepository`: The repository to manage `Marca` entities.
- **Returns**: `void`

### `createProductos(GenericRepository<Producto> productoRepository, GenericRepository<Marca> marcaRepository)`
- **Description**: Creates and saves `Producto` entities.
- **Parameters**:
  - `productoRepository`: The repository to manage `Producto` entities.
  - `marcaRepository`: The repository to manage `Marca` entities.
- **Returns**: `void`

### `createClientes(GenericRepository<Cliente> clienteRepository)`
- **Description**: Creates and saves `Cliente` entities.
- **Parameters**:
  - `clienteRepository`: The repository to manage `Cliente` entities.
- **Returns**: `void`

### `listClientes(GenericRepository<Cliente> clienteRepository)`
- **Description**: Lists all `Cliente` entities.
- **Parameters**:
  - `clienteRepository`: The repository to manage `Cliente` entities.
- **Returns**: `void`

### `createCompras(GenericRepository<Compra> compraRepository, GenericRepository<Cliente> clienteRepository, GenericRepository<Producto> productoRepository)`
- **Description**: Creates and saves `Compra` entities.
- **Parameters**:
  - `compraRepository`: The repository to manage `Compra` entities.
  - `clienteRepository`: The repository to manage `Cliente` entities.
  - `productoRepository`: The repository to manage `Producto` entities.
- **Returns**: `void`

### `listCompras(GenericRepository<Compra> compraRepository)`
- **Description**: Lists all `Compra` entities.
- **Parameters**:
  - `compraRepository`: The repository to manage `Compra` entities.
- **Returns**: `void`

## Example Usage

```java
GenericRepository<Marca> marcaRepository = new GenericRepository<>(new JPAConfig<>());
GenericRepository<Producto> productoRepository = new GenericRepository<>(new JPAConfig<>());
GenericRepository<Cliente> clienteRepository = new GenericRepository<>(new JPAConfig<>());
GenericRepository<Compra> compraRepository = new GenericRepository<>(new JPAConfig<>());

SupermercadoCreator.createMarcas(marcaRepository);
SupermercadoCreator.createProductos(productoRepository, marcaRepository);
SupermercadoCreator.createClientes(clienteRepository);
SupermercadoCreator.listClientes(clienteRepository);
SupermercadoCreator.createCompras(compraRepository, clienteRepository, productoRepository);
SupermercadoCreator.listCompras(compraRepository);