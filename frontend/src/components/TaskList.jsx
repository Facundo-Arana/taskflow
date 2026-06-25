import TaskItem from "./TaskItem";
import "./taskList.css";

function TaskList({ loading, error, taskList, onToggle, onDelete }) {
  const total = taskList.length;
  const completed = taskList.filter((task) => task.completed).length;

  return (
    <div className="task-list-container">
      <h3>Lista de tareas</h3>

      {loading && <p>Cargando tareas...</p>}
      {error && <p className="task-error">{error}</p>}

      {!error && !loading && total === 0 && <p>No hay tareas todavía</p>}
      {!error && !loading && (
        <p className="task-counter">
          {completed} completadas / {total} totales
        </p>
      )}

      <ul className="task-list">
        {taskList.map((task) => (
          <TaskItem
            key={task.id}
            task={task}
            onToggle={onToggle}
            onDelete={onDelete}
          />
        ))}
      </ul>
    </div>
  );
}

export default TaskList;
