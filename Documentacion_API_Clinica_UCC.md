# Documentación API Clínica UCC

## 1. Descripción General

Este proyecto implementa una API REST para la gestión de una clínica médica utilizando Spring Boot. La aplicación permite administrar pacientes, doctores, citas médicas, historias clínicas y tratamientos.

## 2. Estructura del Proyecto

El proyecto sigue una arquitectura de capas con un enfoque en Domain-Driven Design (DDD):

```
uccexample/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/uccexample/
│   │   │       ├── controller/           # Controladores REST
│   │   │       ├── domain/               # Capa de dominio
│   │   │       │   ├── dto/              # Objetos de transferencia de datos
│   │   │       │   ├── irepository/      # Interfaces de repositorios
│   │   │       │   └── service/          # Servicios de negocio
│   │   │       └── infraestructure/      # Capa de infraestructura
│   │   │           ├── crud/             # Repositorios Spring Data JPA
│   │   │           ├── mapper/           # Mappers para conversión entre entidades y DTOs
│   │   │           ├── model/            # Entidades JPA
│   │   │           └── repositories/     # Implementaciones de repositorios
│   │   └── resources/
│   │       ├── application.properties    # Configuración principal
│   │       ├── application-staging.properties    # Configuración para entorno de staging
│   │       └── application-production.properties # Configuración para entorno de producción
│   └── test/
└── pom.xml                               # Configuración de Maven
```

## 3. Tecnologías Utilizadas

- **Spring Boot 3.5.5**: Framework para desarrollo de aplicaciones Java
- **Spring Web**: Para crear endpoints REST
- **Spring Data JPA**: Para acceso a datos
- **MySQL**: Base de datos relacional
- **MapStruct 1.5.5**: Para mapeo entre entidades y DTOs
- **Java 17**: Versión del lenguaje utilizada

## 4. Arquitectura y Patrones de Diseño

### 4.1 Arquitectura en Capas

El proyecto implementa una arquitectura en capas:

1. **Capa de Controladores (Controller)**: Maneja las peticiones HTTP y respuestas.
2. **Capa de Servicios (Service)**: Contiene la lógica de negocio.
3. **Capa de Repositorios**: Gestiona el acceso a datos.
4. **Capa de Modelos**: Define las entidades JPA y DTOs.

### 4.2 Patrones de Diseño

- **Patrón Repository**: Abstrae el acceso a datos.
- **Patrón DTO (Data Transfer Object)**: Separa la representación de datos externa de las entidades internas.
- **Patrón Mapper**: Convierte entre entidades y DTOs.
- **Inyección de Dependencias**: Utilizado a través de Spring para gestionar dependencias.

## 5. Modelos de Datos

### 5.1 Entidades Principales

- **Paciente**: Representa a un paciente de la clínica.
- **Doctor**: Representa a un médico de la clínica.
- **Cita**: Representa una cita médica entre un paciente y un doctor.
- **HistoriaClinica**: Contiene el historial médico de un paciente.
- **Tratamiento**: Representa un tratamiento médico asociado a una cita.

### 5.2 Relaciones

- Un **Paciente** puede tener muchas **Citas** (1:N)
- Un **Paciente** tiene una **HistoriaClinica** (1:1)
- Un **Doctor** puede tener muchas **Citas** (1:N)
- Una **Cita** puede tener muchos **Tratamientos** (1:N)

## 6. API REST

### 6.1 Endpoints

#### Home
- `GET /ucc/api/`: Página de bienvenida a la API

#### Pacientes
- `GET /ucc/api/pacientes`: Obtiene todos los pacientes
- `POST /ucc/api/pacientes`: Crea un nuevo paciente

#### Doctores
- `GET /ucc/api/doctores/`: Obtiene todos los doctores
- `POST /ucc/api/doctores/`: Crea un nuevo doctor

#### Citas
- `GET /ucc/api/citas/`: Obtiene todas las citas
- `POST /ucc/api/citas/`: Crea una nueva cita

#### Historias Clínicas
- `GET /ucc/api/historias-clinicas/`: Obtiene todas las historias clínicas
- `POST /ucc/api/historias-clinicas/`: Crea una nueva historia clínica

#### Tratamientos
- `GET /ucc/api/tratamientos/`: Obtiene todos los tratamientos
- `POST /ucc/api/tratamientos/`: Crea un nuevo tratamiento

### 6.2 Ejemplos de Uso

#### Crear un Paciente
```http
POST http://localhost:8090/ucc/api/pacientes
Content-Type: application/json

{
  "nombre": "Juan",
  "apellido": "Pérez",
  "documento": "1234567890",
  "telefono": "3001234567",
  "direccion": "Calle 123 #45-67"
}
```

#### Obtener todos los Pacientes
```http
GET http://localhost:8090/ucc/api/pacientes
```

## 7. Configuración

### 7.1 Configuración de Base de Datos

La aplicación está configurada para conectarse a una base de datos MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/libreria?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=***********
```

### 7.2 Configuración de Entornos

El proyecto tiene configuraciones para diferentes entornos:

- **Staging**: Puerto 8090 (application-staging.properties)
- **Production**: Puerto 80 (application-production.properties)

El entorno activo se configura en application.properties:
```properties
spring.profiles.active=staging
```

### 7.3 Configuración de Contexto

La aplicación se ejecuta bajo el contexto `/ucc/api`:
```properties
server.servlet.context-path=/ucc/api
```

## 8. Implementación de Mappers

El proyecto utiliza MapStruct para mapear entre entidades y DTOs:

```java
@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mappings ({
        @Mapping(source = "idPaciente", target = "idPaciente"),
        @Mapping(source = "nombre", target = "nombre"),
        // otros campos...
    })
    PacienteDTO toPacienteDTO(Paciente paciente);
    List<PacienteDTO> toPacienteDTOs(List<Paciente> pacientes);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    @Mapping(target = "historiaClinica", ignore = true)
    Paciente toPaciente(PacienteDTO pacienteDTO);
    List<Paciente> toPacientes(List<PacienteDTO> pacienteDTOs);
}
```

## 9. Ejecución del Proyecto

Para ejecutar el proyecto:

1. Asegúrate de tener Java 17 instalado
2. Configura la base de datos MySQL
3. Ejecuta: `mvn spring-boot:run`
4. La API estará disponible en: `http://localhost:8090/ucc/api/`

## 10. Conclusiones

Esta API REST implementa un sistema completo para la gestión de una clínica médica, siguiendo buenas prácticas de desarrollo como:

- Arquitectura en capas
- Separación de responsabilidades
- Uso de DTOs para transferencia de datos
- Mapeo entre entidades y DTOs
- Configuración para diferentes entornos

El sistema permite gestionar pacientes, doctores, citas, historias clínicas y tratamientos, proporcionando una base sólida para una aplicación de gestión clínica completa.