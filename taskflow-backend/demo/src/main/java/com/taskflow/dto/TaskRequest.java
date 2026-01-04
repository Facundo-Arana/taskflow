package com.taskflow.dto;

public class TaskRequest {
	
	String title;
	String description;
	Boolean completed;
	
	public TaskRequest() {}
	
	public TaskRequest(String title, String description, boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
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
