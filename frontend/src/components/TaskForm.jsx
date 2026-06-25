import { useState } from "react";
import "./taskForm.css";

function TaskForm({ loading, onAddTask }) {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const submitTask = (event) => {
        event.preventDefault();
        const taskData = {
            title: title.trim(),
            description: description.trim(),
            completed: false
        };

        if (!taskData.title) return;

        onAddTask(taskData);
        setTitle("");
        setDescription("");
    }

    return (
        <form className="task-form" onSubmit={submitTask}>
            <h3>Agregar una tarea</h3>
            <label htmlFor="task-title">Nombre</label>
            <input
                id="task-title"
                value={title}
                onChange={(event) => setTitle(event.target.value)}
                required
            />

            <label htmlFor="task-description">Descripción</label>
            <textarea
                id="task-description"
                rows="4"
                value={description}
                onChange={(event) => setDescription(event.target.value)}
            ></textarea>

            <input type="submit" value="Agregar tarea" disabled={loading} />
        </form>
    )
}

export default TaskForm;
