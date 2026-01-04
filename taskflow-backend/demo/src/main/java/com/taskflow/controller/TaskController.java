package com.taskflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.dto.TaskRequest;
import com.taskflow.dto.TaskResponse;
import com.taskflow.service.TaskService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/task")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<TaskResponse>> getTask() {
		List<TaskResponse> list = this.taskService.getAllTasks();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {	
		TaskResponse task = this.taskService.getTaskById(id);
		return new ResponseEntity<TaskResponse>(task, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest taskData) {	
		TaskResponse task = this.taskService.updateTask(id, taskData);
		return new ResponseEntity<TaskResponse>(task, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}/toggle")
	public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id) {	
		TaskResponse task = this.taskService.tooggleTask(id);
		return new ResponseEntity<TaskResponse>(task, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {	
		this.taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@PostMapping("")
	public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskData) {
		TaskResponse task = this.taskService.createTask(taskData);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

}
