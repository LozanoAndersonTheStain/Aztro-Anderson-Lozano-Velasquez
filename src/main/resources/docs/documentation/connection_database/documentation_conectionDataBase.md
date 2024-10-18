# Database Configuration Documentation

## DataBaseConfig

### Description
The `DataBaseConfig` class is responsible for establishing a connection to the database using the credentials and URL specified in the environment variables.

### Methods

#### `getConnection()`
- **Description**: Establishes and returns a connection to the database.
- **Returns**: `Connection` - A `Connection` object if the connection is successful, otherwise `null`.
- **Exceptions**: Catches `SQLException` and prints error messages based on the SQL state.

### Fields

- **dotenv**: `Dotenv` - Loads environment variables from a `.env` file.

### Usage
To use the `DataBaseConfig` class, create a `.env` file in the root directory of your project and ensure it contains the following variables:
- `DB_URL`: The URL of the database.
- `DB_USER`: The username for the database.
- `DB_PASSWORD`: The password for the database.


### Example
````
DB_URL=jdbc:postgresql://localhost:0000/database
DB_USER=user
DB_PASSWORD=password
````

Then, call the `getConnection()` method to establish a connection to the database.

### Example
```java
Connection connection = DataBaseConfig.getConnection();
if (connection != null) {
    // Connection established
} else {
    // Connection failed
}