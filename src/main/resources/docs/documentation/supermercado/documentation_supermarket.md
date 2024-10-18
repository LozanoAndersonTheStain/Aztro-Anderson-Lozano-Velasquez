# Supermarket Entities Documentation

This document provides information about the entities used in the Supermarket project.

## Models...
### Producto:

#### Fields
- **id**: `long` - Unique identifier for the product.
- **nombre**: `String` - Name of the product. Cannot be null.
- **precio**: `double` - Price of the product. Cannot be null.
- **marca**: `Marca` - Brand of the product. Many-to-one relationship with `Marca`. Cannot be null.

#### Annotations
- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Id`: Specifies the primary key of an entity.
- `@GeneratedValue`: Provides for the specification of generation strategies for the values of primary keys.
- `@Column`: Used to specify the mapped column for a persistent property or field.
- `@ManyToOne`: Defines a many-to-one relationship.
- `@JoinColumn`: Specifies a column for joining an entity association or element collection.
- `@NotBlank`: Ensures that the field is not null and not empty.
- `@NotNull`: Ensures that the field is not null.

### Compra:

#### Fields
- **id**: `long` - Unique identifier for the purchase.
- **fecha**: `LocalDate` - Date of the purchase. Cannot be null.
- **cliente**: `Cliente` - Customer who made the purchase. Many-to-one relationship with `Cliente`. Cannot be null.
- **productos**: `List<Producto>` - List of products in the purchase. One-to-many relationship with `Producto`.

#### Annotations
- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Id`: Specifies the primary key of an entity.
- `@GeneratedValue`: Provides for the specification of generation strategies for the values of primary keys.
- `@Column`: Used to specify the mapped column for a persistent property or field.
- `@ManyToOne`: Defines a many-to-one relationship.
- `@JoinColumn`: Specifies a column for joining an entity association or element collection.
- `@OneToMany`: Defines a one-to-many relationship.
- `@JoinTable`: Specifies the mapping of associations.
- `@NotNull`: Ensures that the field is not null.

### Marca:

#### Fields
- **id**: `long` - Unique identifier for the brand.
- **nombre**: `String` - Name of the brand. Cannot be null.
- **productos**: `List<Producto>` - List of products under this brand. One-to-many relationship with `Producto`.

#### Annotations
- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Id`: Specifies the primary key of an entity.
- `@GeneratedValue`: Provides for the specification of generation strategies for the values of primary keys.
- `@Column`: Used to specify the mapped column for a persistent property or field.
- `@OneToMany`: Defines a one-to-many relationship.
- `@NotBlank`: Ensures that the field is not null and not empty.
- `@Cascade`: Specifies the cascade operations to be applied to the relationship.

### Cliente:

#### Fields
- **id**: `long` - Unique identifier for the customer.
- **nombre**: `String` - First name of the customer. Cannot be null.
- **apellido**: `String` - Last name of the customer. Cannot be null.
- **compras**: `List<Compra>` - List of purchases made by the customer. One-to-many relationship with `Compra`.

#### Annotations
- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Id`: Specifies the primary key of an entity.
- `@GeneratedValue`: Provides for the specification of generation strategies for the values of primary keys.
- `@Column`: Used to specify the mapped column for a persistent property or field.
- `@OneToMany`: Defines a one-to-many relationship.
- `@NotBlank`: Ensures that the field is not null and not empty.
- `@Cascade`: Specifies the cascade operations to be applied to the relationship.