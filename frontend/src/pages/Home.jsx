import TaskForm from "../components/TaskForm";
import TaskList from "../components/TaskList";
import "./home.css";

function Home({ loading, error, taskList, onToggle, onDelete, onAddTask, onSort }) {
  return (
    <div className="home-container">
     {/*  <h2>Home</h2> */}
      <TaskForm
        loading={loading}
        onAddTask={onAddTask}
      />
     
      <TaskList
        loading={loading} 
        error={error}
        taskList={taskList}
        onToggle={onToggle}
        onDelete={onDelete}
        onSort={onSort}
      />
    </div>
  );
}

export default Home;
