import { useState } from "react";
import "./taskForm.css";


function TaskForm({ loading, onAddTask }) {

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");


    const submitTask = (e) => {
        e.preventDefault();
        let taskData = { "title": title, "description": description, completed: false };
        onAddTask(taskData);
        setTitle("");
        setDescription("");
    }

    return (
        <form className="task-form" onSubmit={submitTask}>
            <h3>Agregar una tarea</h3>
            <label>Nombre</label>
            <input value={title} onChange={(e) => setTitle(e.target.value)} />
            <label>Descripcion</label>
            <textarea rows="4" value={description} onChange={(e) => setDescription(e.target.value)} ></textarea>
           

            <input type="submit" value="Agregar tarea" disabled={loading} />
        </form>
    )
}

export default TaskForm;