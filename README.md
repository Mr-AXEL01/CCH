# CCH - Cycling Competition Management API

## Project Overview

CCH (Cyclo Club Horizon) is a comprehensive API for managing cycling time trial competitions. The application provides robust functionality for managing teams, cyclists, competitions, stages, and race results.

## Technical Stack

### Backend
- **Language:** Java
- **Framework:** Spring (IoC, MVC)
- **ORM:** Hibernate
- **Testing:** JUnit, Mockito

### Configuration Approaches
- XML Configuration
- Annotation-based Configuration
- Java-based Configuration

## Key Features

### REST Endpoints
The API supports comprehensive CRUD operations for:
- Teams
- Cyclists
- Competitions
- Stages
- General Results
- Results

### Persistence Layer
- Utilizes Hibernate SessionFactory
- Implements generic DAO for common database interactions
- Manages transactions via Hibernate and Spring

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── net/axel/
│   │       ├── config/               # Spring and application configurations
│   │       ├── controllers/          # REST API controllers
│   │       ├── domains/              # Domain models and DTOs
│   │       │   ├── dtos/             # Data Transfer Objects
│   │       │   │   ├── competitions/
│   │   │   │   ├── cyclists/
│   │   │   │   ├── generalResults/
│   │   │   │   ├── results/
│   │   │   │   ├── stages/
│   │   │   │   └── teams/
│   │   │   ├── embeddeds/            # Embedded value objects
│   │   │   ├── entities/             # JPA entity classes
│   │   │   └── enums/                # Enumeration types
│   │       ├── exceptions/           # Custom exception classes
│   │       ├── mappers/              # Object mapping utilities
│   │       ├── repositories/         # Data Access Objects (DAOs)
│   │       └── services/             # Business logic layer
│   │           ├── implementations/  # Service implementation classes
│   │           └── interfaces/       # Service interfaces
│   └── webapp/                       # Web application resources
└── test/
└── java/
└── net/axel/
└── services/
└── implementations/  # Unit tests for service implementations
```

## Setup and Installation

### Prerequisites
- Java 22
- Maven
- Tomcat
- PostgreSQL

### Configuration Steps
1. Clone the repository
2. Configure database connection in `config/PersistenceConfig`
3. Run Maven dependency installation
4. Build the project
5. Deploy to Tomcat

## API Endpoints

### Teams
- `GET /api/v1/teams`: List all teams
- `GET /api/v1/teams/{id}`: Get specific team
- `POST /api/v1/teams`: Create team
- `PUT /api/v1/teams/{id}`: Update team
- `DELETE /api/v1/teams/{id}`: Delete team

### Similar endpoints exist for:
- Cyclists
- Competitions
- Stages
- General Results
- Stage Results

## Testing

### Running Tests
```bash
mvn test
```

### Test Coverage
- Unit tests with JUnit
- Mockito for mocking dependencies
- Test-Driven Development (TDD) approach

## Tools and Technologies

- JPA
- Hibernate
- Spring IoC
- Spring MVC
- JUnit
- Mockito
- Tomcat
- ModelMapper/MapStruct
- Postman (API Testing)

## Development Methodology

- Test-Driven Development (TDD)
- Dependency Injection
- RESTful API Design

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact

Cyclo Club Horizon - abdelhakazrour3@gmail.com

Project Link: https://github.com/Mr-AXEL01/CCH
