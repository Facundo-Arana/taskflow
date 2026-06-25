import MainLayout from "./layout/MainLayout";
import Home from "./pages/Home";
import Header from "./components/Header";
import { useEffect, useState } from "react";
import { createTask, deleteTask, getAllTasks, toggleTask } from "./services/taskService";

const sortTasks = (tasks) =>
  [...tasks].sort((a, b) => Number(a.completed) - Number(b.completed));

function App() {
  const [taskList, setTaskList] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    getAllTasks()
      .then((response) => {
        setTaskList(sortTasks(response.data));
        setError(null);
      })
      .catch(() => setError("No se pudieron cargar las tareas"))
      .finally(() => setLoading(false));
  }, []);

  const handleToggle = (id) => {
    toggleTask(id)
      .then((response) => {
        setTaskList((prev) =>
          sortTasks(prev.map((task) =>
            task.id === id ? response.data : task
          ))
        );
        setError(null);
      })
      .catch(() => setError("No se pudo actualizar la tarea"));
  }

  const handleDelete = (id) => {
    deleteTask(id)
      .then(() => {
        setTaskList((prev) => prev.filter((task) => task.id !== id));
        setError(null);
      })
      .catch(() => setError("No se pudo eliminar la tarea"));
  }

  const handleAddTask = (taskData) => {
    createTask(taskData)
      .then((response) => {
        setTaskList((prev) => sortTasks([...prev, response.data]));
        setError(null);
      })
      .catch(() => setError("No se pudo crear la tarea"));
  }

  return (
    <MainLayout>
      <Header />
      <Home
        loading={loading}
        error={error}
        taskList={taskList}
        onToggle={handleToggle}
        onDelete={handleDelete}
        onAddTask={handleAddTask}
      />
    </MainLayout>
  )
}

export default App;
