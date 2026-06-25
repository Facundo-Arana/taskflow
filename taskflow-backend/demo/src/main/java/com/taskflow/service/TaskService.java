package com.taskflow.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.taskflow.dto.TaskRequest;
import com.taskflow.dto.TaskResponse;
import com.taskflow.mapper.TaskMapper;
import com.taskflow.model.Task;
import com.taskflow.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	public List<TaskResponse> getAllTasks() {	
		return this.taskRepository.findAll().stream()
	            .map(TaskMapper::toResponse)
	            .toList();
	}
	
	public TaskResponse createTask(TaskRequest taskRequest) {
		Task entity = TaskMapper.toEntity(taskRequest);
	    Task saved = this.taskRepository.save(entity);
	    return TaskMapper.toResponse(saved);
	}

	public TaskResponse getTaskById(Long id) {
		Task task = this.taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id: " + id)); 
		return TaskMapper.toResponse(task);
	}
	
	public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
		Task task = this.taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id: " + id));
		TaskMapper.updateEntity(task, taskRequest);
		Task updated = this.taskRepository.save(task);
		return TaskMapper.toResponse(updated);
	}
	
	public TaskResponse toggleTask(Long id) {
		Task task = this.taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id: " + id));
		task.setCompleted(!task.isCompleted());
		Task updated = this.taskRepository.save(task);
		return TaskMapper.toResponse(updated);
	}
	
	public void deleteTask(Long id) {
		Task task = this.taskRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la tarea con id: " + id));
		this.taskRepository.delete(task);
	}

	
	
}
