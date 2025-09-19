# Banque Java Application

A simple banking management system implemented in Java, supporting account creation, deposits, withdrawals, transfers, and interest calculation. The project uses a layered architecture with DTOs, services, repositories, and a console-based UI.

## Features

- Create current and savings accounts
- Deposit and withdraw funds
- Transfer money between accounts
- Calculate interest for savings accounts
- In-memory and (planned) database persistence
- Console-based user interface

## Project Structure
- **Main** :  entry point 
- **application**  : Service and mapper layers 
- **domain** :  Core business entities, enums, exceptions, repositories, and utilities 
- **infrastructure** : Configuration and persistence implementations 
- **presentation** :  Console UI, controllers, and DTOs lib/ 
- **lib** : External libraries (e.g., JDBC driver)

### Key Packages

- `banque.domain.entity` - Account and operation entities
- `banque.domain.repository` - Repository interfaces
- `banque.domain.exception` - Custom exceptions
- `banque.application.service` - Business logic/services
- `banque.application.mapper` - DTO/entity mappers
- `banque.infrastructure.persistence` - In-memory and (planned) DB repository implementations
- `banque.infrastructure.config` - Global configuration and DB setup
- `banque.presentation` - Console UI and controllers
- `banque.presentation.dto` - Data Transfer Objects for UI/service communication

## Getting Started

### Prerequisites

- Java 8 or higher
- (Optional) PostgreSQL and JDBC driver if using database persistence

### Build & Run

1. **Compile the project:**
   ```sh
   cd src/banque
   javac -cp "lib/postgresql.jar" -d out $(find . -name "*.java")```

2. Run the application:
``` java -cp "out:lib/postgresql.jar" banque.Main ```

Or use the provided script:

``` bash executer.sh ```

### Configuration

- Edit GlobalValue.java to switch between in-memory and database persistence and to set DB credentials.

### Usage
- Follow the console prompts to create accounts, perform operations, and view balances or interest.


### Authors
Younes Bousfiha