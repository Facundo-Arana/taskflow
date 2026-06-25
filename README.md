# TaskFlow

TaskFlow es una aplicación fullstack para gestionar tareas, desarrollada como proyecto de portfolio.
El objetivo del proyecto es mostrar una integración clara entre un frontend moderno en React y una API REST en Spring Boot.

## Stack

Frontend:

- React
- Vite
- Axios
- CSS modular por componente

Backend:

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- Springdoc OpenAPI

## Funcionalidades

- Crear tareas.
- Listar tareas.
- Marcar tareas como completadas o pendientes.
- Eliminar tareas.
- Ver contador de tareas completadas y totales.
- Manejar estados de carga y error.

## Arquitectura

El repositorio contiene frontend y backend separados:

```text
taskflow/
├── frontend/              # Aplicación React con Vite
└── taskflow-backend/demo/ # API REST con Spring Boot
```

Backend:

```text
controller -> service -> repository -> database
                |
              mapper
                |
               DTOs
```

La API no expone directamente la entidad `Task`: utiliza `TaskRequest` para recibir datos y `TaskResponse` para responder.

## API REST

Base URL local:

```text
http://localhost:8080/api/task
```

Endpoints principales:

| Método | Endpoint | Descripción |
| --- | --- | --- |
| GET | `/api/task` | Lista todas las tareas |
| GET | `/api/task/{id}` | Obtiene una tarea por ID |
| POST | `/api/task` | Crea una tarea |
| PUT | `/api/task/{id}` | Actualiza una tarea |
| PATCH | `/api/task/{id}/toggle` | Alterna el estado completado/pendiente |
| DELETE | `/api/task/{id}` | Elimina una tarea |

## Cómo ejecutar

### Backend

Desde `taskflow-backend/demo`:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

La API queda disponible en:

```text
http://localhost:8080
```

Para habilitar configuración de desarrollo con consola H2 y logs SQL:

```bash
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev
```

### Frontend

Desde `frontend`:

```bash
npm install
npm run dev
```

La aplicación queda disponible en:

```text
http://localhost:5173
```

## Variables de entorno

Frontend:

```env
VITE_API_URL=http://localhost:8080/api/task
```

Backend:

```env
SERVER_PORT=8080
DB_URL=jdbc:h2:mem:taskflowdb
DB_DRIVER=org.h2.Driver
DB_USERNAME=sa
DB_PASSWORD=
JPA_DDL_AUTO=update
JPA_SHOW_SQL=false
H2_CONSOLE_ENABLED=false
```

## Validaciones y errores

El backend valida los datos de entrada con Bean Validation.
Por ejemplo, el título de una tarea no puede estar vacío.

Los errores se centralizan en `GlobalHandlerException`, devolviendo respuestas consistentes para:

- Validaciones fallidas.
- Recursos no encontrados.
- Errores internos.

## Calidad

Comandos de verificación:

Frontend:

```bash
npm run lint
npm run build
```

Backend:

```bash
mvnw.cmd test
```

El backend incluye tests de integración para creación, validación, cambio de estado y errores 404.

## Notas técnicas

- La base de datos H2 corre en memoria, por lo que los datos se reinician al reiniciar el backend.
- La URL de la API en el frontend se configura con `VITE_API_URL`.
- La consola H2 está deshabilitada por defecto y puede habilitarse con el perfil `dev`.
- El proyecto evita agregar autenticación para mantener el alcance simple y claro como demo de portfolio.

## Licencia

Proyecto de uso educativo y de portfolio.
