# Event Registration System - Project Structure

## Project Overview
An event registration system that allows organizers to create events and participants to register for them. The system includes user authentication and management, built using Spring Boot with a microservices architecture.

## Team Structure
- **Team 1 (Event Service)**: [Member 1, Member 2]
- **Team 2 (Registration Service)**: [Member 3, Member 4]
- **Team 3 (Gateway & UI)**: [Member 5, Member 6]
- **Team 4 (User Service)**: [Assign to an existing team or new members]

## Technology Stack
- Java 17
- Spring Boot 3.2
- Spring Cloud
- PostgreSQL
- Spring Data JPA
- Spring Security
- RESTful APIs
- Docker (for containerization)
- Maven/Gradle (build tool)

## Project Structure

```
event-registration-system/
├── docker-compose.yml
├── pom.xml (parent pom)
├── README.md
├── docs/
│   ├── SRS/
│   │   ├── use-case-diagrams/
│   │   ├── activity-diagrams/
│   │   ├── sequence-diagrams/
│   │   ├── class-diagrams/
│   │   └── ERD/
│   └── SDD/
├── event-service/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/com/university/eventservice/
│       │   │   ├── EventServiceApplication.java
│       │   │   ├── controller/
│       │   │   │   └── EventController.java
│       │   │   ├── model/
│       │   │   │   └── Event.java
│       │   │   ├── repository/
│       │   │   │   └── EventRepository.java
│       │   │   ├── service/
│       │   │   │   ├── EventService.java
│       │   │   │   └── EventServiceImpl.java
│       │   │   ├── dto/
│       │   │   │   ├── EventDTO.java
│       │   │   │   └── EventResponseDTO.java
│       │   │   └── aspect/
│       │   │       └── LoggingAspect.java
│       │   └── resources/
│       │       └── application.yml
│       └── test/
├── registration-service/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/com/university/registrationservice/
│       │   │   ├── RegistrationServiceApplication.java
│       │   │   ├── controller/
│       │   │   │   └── RegistrationController.java
│       │   │   ├── model/
│       │   │   │   ├── Registration.java
│       │   │   │   └── Participant.java
│       │   │   ├── repository/
│       │   │   │   ├── RegistrationRepository.java
│       │   │   │   └── ParticipantRepository.java
│       │   │   ├── service/
│       │   │   │   ├── RegistrationService.java
│       │   │   │   └── RegistrationServiceImpl.java
│       │   │   ├── dto/
│       │   │   │   └── RegistrationDTO.java
│       │   │   └── aspect/
│       │   │       └── LoggingAspect.java
│       │   └── resources/
│       │       └── application.yml
│       └── test/
├── user-service/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/com/university/userservice/
│       │   │   ├── UserServiceApplication.java
│       │   │   ├── controller/
│       │   │   │   ├── AuthController.java
│       │   │   │   └── UserController.java
│       │   │   ├── model/
│       │   │   │   ├── User.java
│       │   │   │   ├── Role.java
│       │   │   │   └── UserRole.java
│       │   │   ├── repository/
│       │   │   │   ├── UserRepository.java
│       │   │   │   └── RoleRepository.java
│       │   │   ├── service/
│       │   │   │   ├── UserService.java
│       │   │   │   ├── UserServiceImpl.java
│       │   │   │   ├── AuthService.java
│       │   │   │   └── AuthServiceImpl.java
│       │   │   ├── dto/
│       │   │   │   ├── UserDTO.java
│       │   │   │   ├── LoginRequest.java
│       │   │   │   ├── SignupRequest.java
│       │   │   │   ├── JwtResponse.java
│       │   │   │   └── MessageResponse.java
│       │   │   ├── security/
│       │   │   │   ├── WebSecurityConfig.java
│       │   │   │   ├── jwt/
│       │   │   │   │   ├── JwtUtils.java
│       │   │   │   │   └── AuthTokenFilter.java
│       │   │   │   └── services/
│       │   │   │       └── UserDetailsServiceImpl.java
│       │   │   ├── exception/
│       │   │   │   └── GlobalExceptionHandler.java
│       │   │   └── aspect/
│       │   │       └── LoggingAspect.java
│       │   └── resources/
│       │       └── application.yml
│       └── test/
├── discovery-service/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/com/university/discoveryservice/
│           │   └── DiscoveryServiceApplication.java
│           └── resources/
│               └── application.yml
├── api-gateway/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/com/university/apigateway/
│           │   ├── ApiGatewayApplication.java
│           │   ├── config/
│           │   │   ├── RouteConfig.java
│           │   │   └── SecurityConfig.java
│           │   └── filter/
│           │       └── JwtAuthenticationFilter.java
│           └── resources/
│               └── application.yml
└── ui-service/
    ├── pom.xml
    └── src/
        └── main/
            ├── java/com/university/uiservice/
            │   └── UiServiceApplication.java
            └── resources/
                ├── application.yml
                ├── static/
                │   ├── css/
                │   ├── js/
                │   │   └── auth.js
                │   └── images/
                └── templates/
                    ├── index.html
                    ├── login.html
                    ├── register.html
                    ├── user-profile.html
                    └── events/
```

## Communications Between Services

```
┌──────────────┐      ┌──────────────┐
│  UI Service  │─────>│  API Gateway  │
└──────────────┘      └───────┬──────┘
                              │
                              ▼
┌─────────────────────────────────────┐
│                                     │
▼                   ▼                 ▼
┌──────────┐    ┌──────────┐    ┌──────────┐
│   User   │◄──►│   Event  │◄──►│Registration│
│ Service  │    │ Service  │    │  Service  │
└──────────┘    └──────────┘    └──────────┘
     │                │              │
     │                │              │
     ▼                ▼              ▼
┌──────────┐    ┌──────────┐    ┌──────────┐
│   User   │    │  Event   │    │Registration│
│   DB     │    │   DB     │    │    DB     │
└──────────┘    └──────────┘    └──────────┘
```

## Service Details and Responsibilities

### Event Service (Team 1)
**Responsibilities:**
- Create events with details (name, date, location, capacity)
- Update event information
- Cancel events
- Reschedule events
- List events (upcoming, past, by category)

**Key Endpoints:**
- `POST /api/events` - Create a new event
- `GET /api/events` - Get all events
- `GET /api/events/{id}` - Get event by ID
- `PUT /api/events/{id}` - Update event
- `DELETE /api/events/{id}` - Cancel event
- `PATCH /api/events/{id}/reschedule` - Reschedule event

### Registration Service (Team 2)
**Responsibilities:**
- Register participants for events
- Cancel registrations
- List participants for an event
- Check event capacity
- Verify participant eligibility

**Key Endpoints:**
- `POST /api/registrations` - Register for an event
- `DELETE /api/registrations/{id}` - Cancel registration
- `GET /api/events/{eventId}/registrations` - Get all registrations for an event
- `GET /api/participants/{id}/registrations` - Get all registrations for a participant

### User Service (Team 4)
**Responsibilities:**
- User authentication (login)
- User registration (signup)
- User profile management
- Role-based authorization

**Key Endpoints:**
- `POST /api/auth/signup` - Register a new user
- `POST /api/auth/login` - Authenticate user and return JWT token
- `GET /api/users/{id}` - Get user profile
- `PUT /api/users/{id}` - Update user profile

### API Gateway & UI Service (Team 3)
**Responsibilities:**
- Route requests to appropriate services
- Implement authentication and authorization
- Provide service discovery
- Develop user interface (web pages)
- Handle cross-cutting concerns

## Database Design

### Event Service Database
- **Events**
    - id (PK)
    - name
    - description
    - location
    - start_date
    - end_date
    - capacity
    - status (UPCOMING, ONGOING, COMPLETED, CANCELLED)
    - organizer_id
    - created_at
    - updated_at

### Registration Service Database
- **Participants**
    - id (PK)
    - name
    - email
    - phone
    - created_at
    - updated_at

- **Registrations**
    - id (PK)
    - event_id
    - participant_id
    - registration_date
    - status (CONFIRMED, CANCELLED, WAITLISTED)
    - created_at
    - updated_at

### User Service Database
- **Users**
    - id (PK)
    - username
    - email
    - password (encrypted)
    - first_name
    - last_name
    - phone_number
    - enabled (boolean)
    - account_non_locked (boolean)
    - account_non_expired (boolean)
    - credentials_non_expired (boolean)
    - last_login_date
    - created_at
    - updated_at

- **Roles**
    - id (PK)
    - name (ROLE_USER, ROLE_ADMIN, ROLE_ORGANIZER)

- **User_Roles** (Junction table)
    - user_id (FK)
    - role_id (FK)

## Development Process
1. Develop and test microservices independently
2. Use Docker to containerize each service
3. Integrate services using Docker Compose
4. Implement CI/CD pipeline (optional)

## Authentication Flow
1. User registers or logs in through the UI Service
2. Request is forwarded to the User Service through API Gateway
3. User Service authenticates the user and issues a JWT token
4. UI Service stores the JWT token (usually in localStorage)
5. Subsequent requests include the JWT token in the Authorization header
6. API Gateway validates tokens before forwarding requests to other services
7. Each service performs additional authorization checks for specific operations

## Documentation Requirements (Based on Grading Criteria)
1. **SRS Documentation (20%)**
    - Use Case Diagrams
    - Activity Diagrams
    - Sequence Diagrams
    - Class Diagrams
    - Entity Relationship Diagrams

2. **SDD Documentation (20%)**
    - Detailed technical documentation
    - System architecture
    - Interface specifications
    - Database design
    - Error handling

3. **Implementation (20%)**
    - Working code that meets requirements
    - Unit tests
    - Integration tests

4. **OCL (15%)**
    - Object Constraint Language specifications
    - Formal constraints on classes and methods

5. **Aspect-Oriented Programming (15%)**
    - Logging aspect
    - Security aspect
    - Transaction aspect
    - Performance monitoring aspect

6. **Microservices (10%)**
    - Service decomposition
    - Inter-service communication
    - Service discovery
    - API Gateway