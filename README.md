# Speed Dating

## Overview
This REST API is designed to manage speed dating events, allowing users to create events, participate in dating rounds, submit votes, and discover matches. Built with Spring Boot and PostgreSQL, it follows REST architecture principles and best practices.

## Key Features
- Speed Dating Event Creation and Management
- Participant Registration System
- Real-time Round Management
- Voting System
- Match Generation
- JWT Authentication
- Email Notifications

## Project Structure
```
src/main/java/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/            # Data Transfer Objects
├── exception/      # Custom exceptions and handlers
├── model/          # Entity classes
├── repository/     # Data access layer
├── request/        # Request models
├── response/       # Response models
└── service/        # Business logic layer

src/main/resources/
├── database_schema.sql  # Database schema definitions
└── application.properties
```

## API Endpoints

### 1. Event Management
POST /api/events/new
- Creates a new speed dating event
- Required fields: name, duration, dateTime, participants
- Returns event ID and rotation schedule

### 2. Voting System
POST /api/votes
- Allows participants to vote for their dates
- Requires JWT authentication
- Required fields: votedEmail
- Automatically validates voter against event registration

### 3. Match Generation
POST /api/matches
- Generates and retrieves matches for an event
- Required parameter: eventId
- Returns list of successful matches based on mutual votes

## Technical Stack
- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **API Testing**: Insomnia
- **Security**: JWT Authentication
- **Architecture**: REST API
- **Design Pattern**: MVC

## Security Implementation
- JWT-based authentication
- Token includes user email and event_id claims
- Bearer token required for protected endpoints
- Request validation using @Valid annotation
- Custom JWT service for token management

## API Response Format
All endpoints return standardized responses:
```json
{
    "message": "Operation status message",
    "data": {
        // Endpoint-specific response data
    }
}
```

## Error Handling
- 400 Bad Request: Invalid requests or validation errors
- 401 Unauthorized: Invalid or missing JWT token
- 200 OK: Successful operations
- Custom exception handlers for business logic errors

## Setup Requirements
1. Java 17+
2. PostgreSQL database
3. JWT secret key configuration
4. Application properties configuration

## Installation & Running
```bash
# Clone the repository
git clone [repository-url]

# Navigate to project directory
cd speed-dating-api

# Create database
psql -U postgres -f src/main/resources/database_schema.sql

# Build the project
./gradlew clean build

# Run the application
./gradlew bootRun
```

## Environment Variables
```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/speed_dating
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
```

## Build Configuration
```groovy
plugins {
    id 'org.springframework.boot' version '3.x.x'
    id 'io.spring.dependency-management'
    id 'java'
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.postgresql:postgresql'
    implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
    runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
    runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'
}
```

## API Testing
The project includes an Insomnia collection for API testing. Import the provided collection to test all endpoints.

## Contributing
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

