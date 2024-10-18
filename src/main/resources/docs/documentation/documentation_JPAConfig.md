# JPAConfig Documentation

## Description
The `JPAConfig` class is responsible for configuring and managing the `EntityManagerFactory` and `EntityManager` for JPA operations. It provides methods for common CRUD operations and transaction management.

## Fields

- **entityManagerFactory**: `EntityManagerFactory` - Factory for creating `EntityManager` instances.
- **entityManager**: `EntityManager` - Manages the persistence context.

## Methods

### `JPAConfig()`
- **Description**: Constructor that initializes the `EntityManagerFactory` and `EntityManager`.
- **Usage**: Creates a new instance of `JPAConfig`.

### `save(T entity)`
- **Description**: Persists the given entity to the database.
- **Parameters**: 
  - `entity`: The entity to be persisted.
- **Returns**: `void`

### `find(Class<T> entityClass, Object primaryKey)`
- **Description**: Finds an entity by its primary key.
- **Parameters**: 
  - `entityClass`: The class of the entity.
  - `primaryKey`: The primary key of the entity.
- **Returns**: The found entity or `null` if not found.

### `findAll(Class<T> entityClass)`
- **Description**: Finds all entities of the given class.
- **Parameters**: 
  - `entityClass`: The class of the entities.
- **Returns**: `List<T>` - A list of all found entities.

### `delete(Class<T> entityClass, Object primaryKey)`
- **Description**: Deletes an entity by its primary key.
- **Parameters**: 
  - `entityClass`: The class of the entity.
  - `primaryKey`: The primary key of the entity.
- **Returns**: `void`

### `update(T entity)`
- **Description**: Merges the state of the given entity into the current persistence context.
- **Parameters**: 
  - `entity`: The entity to be updated.
- **Returns**: `void`

### `close()`
- **Description**: Closes the `EntityManager` and `EntityManagerFactory`.
- **Returns**: `void`
- **Usage**: This method should be called to release the resources held by the `EntityManager` and `EntityManagerFactory` when they are no longer needed.

## Example Usage

```java
JPAConfig<Product> jpaConfig = new JPAConfig<>();
Product product = new Product();
jpaConfig.save(product);
Product foundProduct = jpaConfig.find(Product.class, product.getId());
List<Product> products = jpaConfig.findAll(Product.class);
jpaConfig.update(product);
jpaConfig.delete(Product.class, product.getId());
jpaConfig.close();