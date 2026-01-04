package com.taskflow.service;

import java.util.List;
import java.util.Optional;

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
		Task task = this.taskRepository.getReferenceById(id); 
		return TaskMapper.toResponse(task);
	}
	
	public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
		Optional<Task> optionalTask = this.taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			TaskMapper.updateEntity(optionalTask.get(), taskRequest);
			Task updated = this.taskRepository.save(optionalTask.get());
			return TaskMapper.toResponse(updated);
		} else {
			throw new RuntimeException("Entity not found with ID: " + id);
		}
	}
	
	public TaskResponse tooggleTask(Long id) {
		Optional<Task> optionalTask = this.taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			Task task = optionalTask.get();
			task.setCompleted(!task.isCompleted());
			Task updated = this.taskRepository.save(task);
			return TaskMapper.toResponse(updated);
		} else {
			throw new EntityNotFoundException("No existe la tarea con id: " + id);
		}
	}
	
	public void deleteTask(Long id) {
		Optional<Task> optionalTask = this.taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			this.taskRepository.delete(this.taskRepository.findById(id).get());
		} else {
			throw new EntityNotFoundException("No existe la tarea con id: " + id);
		}
	}

	
	
}
