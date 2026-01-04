# TaskFlow – Frontend

Frontend de **TaskFlow**, una aplicación de gestión de tareas tipo ToDo, desarrollada con **React**.  
Consume una API REST construida en Spring Boot.

## 🛠️ Tecnologías

- React
- Vite
- Axios
- CSS plano (por componente)
- JavaScript (ES6+)

## ⚙️ Funcionalidades

- Listar tareas
- Crear nuevas tareas
- Marcar tareas como completadas
- Eliminar tareas
- Mostrar contador de tareas completadas / totales
- Manejo de estados de carga y error
- Consumo de API vía Axios

## 🔗 Backend

El frontend espera que el backend esté corriendo en:

http://localhost:8080


Endpoints utilizados:
- `GET /api/task`
- `POST /api/task`
- `PUT /api/task/{id}`
- `DELETE /api/task/{id}`

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio
2. Instalar dependencias:

    ```bash
    npm install

3. Ejecutar en modo desarrollo:

    ```bash
    npm run dev

4. Abrir en el navegador: http://localhost:5173

## 📌 Notas

    El estado global de las tareas se maneja en App.jsx

    Los componentes son funcionales y usan hooks (useState, useEffect)

    Los estilos están separados por componente para facilitar el mantenimiento

## 🚀 Próximas mejoras

    Mejoras visuales (UI/UX)

    Manejo de formularios controlados

    Feedback visual (toasts, loaders)

    Deploy
