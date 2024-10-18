# AbstractRepository Documentation

## Description
The `AbstractRepository` class is an abstract base class for repository implementations. It provides common functionality for managing the lifecycle of the `EntityManager` through the `JPAConfig` configuration.

## Fields

- **jpaConfig**: `JPAConfig<T>` - Configuration object for JPA, which includes the `EntityManager`.

## Annotations

- `@AllArgsConstructor`: Generates a constructor with one parameter for each field in the class.
- `@NoArgsConstructor`: Generates a no-argument constructor.
- `@Getter`: Generates getter methods for all fields in the class.

## Methods

### `close()`
- **Description**: Closes the `EntityManager` if it is not null.
- **Returns**: `void`
- **Usage**: This method should be called to release the resources held by the `EntityManager` when it is no longer needed.

## Example Usage

```java
public class ProductRepository extends AbstractRepository<Product> {
    // Repository-specific methods
}

// Usage
ProductRepository productRepository = new ProductRepository(new JPAConfig<>());
productRepository.close();