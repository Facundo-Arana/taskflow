# TaskFlow 🗂️

TaskFlow es una aplicación fullstack para la gestión de tareas, desarrollada como proyecto de portfolio.  
Permite crear, listar, actualizar, completar y eliminar tareas, con un frontend moderno en React y un backend REST en Spring Boot.

---

## Arquitectura del proyecto

El repositorio contiene frontend y backend en un mismo proyecto, organizados de la siguiente manera:

taskflow/
- frontend/          Aplicación React (Vite)
- taskflow-backend/  API REST con Spring Boot

Frontend:
- React
- Vite
- Axios

Backend:
- Spring Boot
- Spring Data JPA
- H2 Database

Comunicación:
- API REST (JSON)

---

## Funcionalidades

- Crear tareas
- Listar tareas
- Marcar tareas como completadas
- Eliminar tareas
- Contador de tareas completadas / totales
- Manejo de estados de carga y error
- Manejo global de excepciones en backend
- CORS configurado para integración frontend-backend

---

## Requisitos

- Node.js 18 o superior
- Java 17
- Maven
- Navegador web moderno

---

## Cómo ejecutar el proyecto

### Backend (Spring Boot)

1. Abrir la carpeta taskflow-backend en el IDE.
2. Ejecutar la clase principal anotada con @SpringBootApplication.
3. El backend se levanta en:

http://localhost:8080

Principales endpoints:

- GET    /api/task
- POST   /api/task
- PUT    /api/task/{id}
- PATCH  /api/task/{id}/toggle
- DELETE /api/task/{id}

---

### Frontend (React)

1. Abrir una terminal en la carpeta frontend.
2. Instalar dependencias:

    npm install

3. Ejecutar la aplicación:

    npm run dev

4. Acceder desde el navegador:

    http://localhost:5173

El frontend se conecta al backend en http://localhost:8080.

---

## Base de datos

- Se utiliza H2 en memoria
- No requiere configuración adicional
- Los datos se reinician al reiniciar el backend

---

## Notas técnicas

- El estado global de tareas se maneja en el componente App.
- TaskForm y TaskList se comunican mediante props.
- Axios se utiliza para la comunicación HTTP.
- El backend expone una API REST desacoplada del frontend.
- El proyecto está preparado para escalar a base de datos persistente y autenticación.

---

## Licencia

Proyecto de uso educativo y de portfolio.
