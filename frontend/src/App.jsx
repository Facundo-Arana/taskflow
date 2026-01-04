import MainLayout from "./layout/MainLayout";
import Home from "./pages/Home";
import Header from "./components/Header";
import { useState, useEffect } from "react";
import { getAllTasks, createTask, toggleTask, deleteTask } from "./services/taskService";


function App() {

  const [taskList, setTaskList] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error , setError] = useState(null);

  useEffect(() => {
    getAllTasks()
      .then(response => {     
        setTaskList(response.data);
        sort();
      })
      .catch(() => setError('No se pudieron cargar las tareas'))
      .finally(() => setLoading(false));
  }, []);


  const handleToggle = (id) => {
    toggleTask(id)
      .then(response => {
        setTaskList(prev =>
          prev.map(task =>
            task.id === id ? response.data : task
          )
        )
        //sort();
      })
  }

  const handleDelete = (id) => {
    deleteTask(id)
      .then(() => {
        setTaskList(prev => prev.filter(task => task.id !== id))
        //sort();
      })
      .catch(err => {

        //console.error(err);
      });
  }

  const handleAddTask = (taskData) => {
    createTask(taskData)
      .then(response => {
        setTaskList(prev => [...prev, response.data]);
      })
      .catch(err => /* console.error(err) */ '');
  }

  const handleSort = () => {
    sort();
  }

  const sort = () => {
    setTaskList(prev =>
      [...prev].sort((a, b) => Number(a.completed) - Number(b.completed))
    );
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
        handleSort={handleSort}
      />


    </MainLayout>
  )
}

export default App;
