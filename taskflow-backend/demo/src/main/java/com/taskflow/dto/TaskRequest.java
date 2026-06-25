package com.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRequest {

	@NotBlank(message = "El título no puede estar vacío")
	private String title;
	private String description;
	@NotNull(message = "El estado de la tarea es obligatorio")
	private Boolean completed;

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
		return Boolean.TRUE.equals(this.completed);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
