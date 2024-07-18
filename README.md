# Persistence Configuration and Audit Entity

## 📚 Persistence Configuration (`PersistenceConfig`)

The `PersistenceConfig` class is responsible for configuring the persistence layer of the application. This includes setting up data sources, entity managers, transaction managers, and other JPA-related configurations. It ensures that the application can interact with the database efficiently and effectively.

### Key Features

- **Configuration**: Execute initiate project to take @Bean in scope runtime.
- **EnableJpaAuditing**: Configures the entity manager factory, which is responsible for managing the entities.
    +  _auditorAwareRef = "auditorProvider"_: Configure `@CreatedBy` and `@LastModifiedBy`
    +  _dateTimeProviderRef = "auditingDateTimeProvider""_: Configure `@CreatedDate` and `@LastModifiedDate`

## 🛡️ Audit Entity (`AuditEntity`)

The `AuditEntity` is a base class that other entities inherit from to gain auditing capabilities. It typically includes fields such as `createdAt`, `createdBy`, `updatedAt`, and `updatedBy`. These fields automatically get populated whenever an entity is created or updated, providing a history of changes.

### Implementation

Entities that require auditing should extend the `AuditEntity`. This approach promotes code reuse and simplifies the maintenance of the auditing functionality.

```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SomeEntity extends AuditEntity {
    // Entity fields
}
