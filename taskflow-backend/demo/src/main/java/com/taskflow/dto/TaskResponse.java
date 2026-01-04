package com.taskflow.dto;

public class TaskResponse {
	
	Long id;
	String title;
	String description;
	Boolean completed;
	
	public TaskResponse() {}
	
	public TaskResponse(Long id, String title, String description, boolean completed) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isCompleted() {
		return this.completed;
	}

}
