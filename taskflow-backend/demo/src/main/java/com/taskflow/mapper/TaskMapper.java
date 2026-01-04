package com.taskflow.mapper;

import com.taskflow.dto.TaskRequest;
import com.taskflow.dto.TaskResponse;
import com.taskflow.model.Task;

public class TaskMapper {
	
	// Request → Entity 
    public static Task toEntity(TaskRequest request) {
        if (request == null) return null;

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        return task;
    }

    // Entity → Response 
    public static TaskResponse toResponse(Task task) {
        if (task == null) return null;

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

    // Request → Entity 
    public static void updateEntity(Task task, TaskRequest request) {
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
    }

}
