# Event Registration System - Project Structure and Task Division

## Project Overview
An event registration system that allows organizers to create events and participants to register for them. The system will be built using Spring Boot with a microservices architecture.

## Team Structure
- **Team 1 (Event Service)**: [Member 1, Member 2]
- **Team 2 (Registration Service)**: [Member 3, Member 4]
- **Team 3 (Gateway & UI)**: [Member 5, Member 6]

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
│           │   └── ApiGatewayApplication.java
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
                └── templates/
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

## Communication Between Services
- Event Service will provide event information to Registration Service
- Registration Service will update event capacity in Event Service
- All communications will be through RESTful APIs
- Service discovery will be handled by Spring Cloud Netflix Eureka

## Development Process
1. Develop and test microservices independently
2. Use Docker to containerize each service
3. Integrate services using Docker Compose
4. Implement CI/CD pipeline (optional)

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
