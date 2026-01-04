import './taskItem.css';

function TaskItem({ task, onToggle, onDelete }) {


  const handleToggle = () => {
    onToggle(task.id);
  }

  const handleDelete = () => {
    onDelete(task.id)
  }

  return (
    <li className="task">
      <div>
        <label  className="checkbox-container">

          <input
            type="checkbox"
            checked={task.completed}
            onChange={handleToggle}
          />
          <span className="checkmark"></span>
        </label>
      </div>
      <div className="task-data"> 
        <div>
          <p className="task-item-title">
            <span className={task.completed ? "completed" : ""}>
              {task.title}
            </span>
          </p>

          <p className="task-item-description">
            <span className={task.completed ? "completed" : ""}>
              {task.description}
            </span>
          </p>
        </div>


        <button className={`delete-item ${task.completed ? 'completed' : ''}`} onClick={handleDelete}></button>
      </div>
    </li>
  );
}

export default TaskItem;
