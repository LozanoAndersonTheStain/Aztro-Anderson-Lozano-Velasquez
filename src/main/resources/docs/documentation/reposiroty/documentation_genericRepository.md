# GenericRepository Documentation

## Description
The `GenericRepository` class is a generic repository implementation that extends the `AbstractRepository` class. It provides common CRUD operations for any entity type.

## Fields

- **jpaConfig**: `JPAConfig<T>` - Configuration object for JPA, which includes the `EntityManager`.

## Annotations

- `@AllArgsConstructor`: Generates a constructor with one parameter for each field in the class.
- `@NoArgsConstructor`: Generates a no-argument constructor.
- `@Getter`: Generates getter methods for all fields in the class.

## Methods

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
- **Description**: Closes the `EntityManager` if it is not null.
- **Returns**: `void`
- **Usage**: This method should be called to release the resources held by the `EntityManager` when it is no longer needed.

## Example Usage

```java
public class ProductRepository extends GenericRepository<Product> {
    // Repository-specific methods
}

// Usage
ProductRepository productRepository = new ProductRepository(new JPAConfig<>());
Product product = new Product();
productRepository.save(product);
Product foundProduct = productRepository.find(Product.class, product.getId());
List<Product> products = productRepository.findAll(Product.class);
productRepository.update(product);
productRepository.delete(Product.class, product.getId());
productRepository.close();