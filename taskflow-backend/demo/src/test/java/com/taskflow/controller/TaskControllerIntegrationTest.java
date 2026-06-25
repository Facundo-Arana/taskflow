package com.taskflow.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.taskflow.model.Task;
import com.taskflow.repository.TaskRepository;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TaskRepository taskRepository;

	@BeforeEach
	void setUp() {
		taskRepository.deleteAll();
	}

	@Test
	void createTaskReturnsCreatedTask() throws Exception {
		String request = """
				{
					"title": "Preparar portfolio",
					"description": "Revisar proyecto TaskFlow",
					"completed": false
				}
				""";

		mockMvc.perform(post("/api/task")
						.contentType(MediaType.APPLICATION_JSON)
						.content(request))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.title").value("Preparar portfolio"))
				.andExpect(jsonPath("$.description").value("Revisar proyecto TaskFlow"))
				.andExpect(jsonPath("$.completed").value(false));
	}

	@Test
	void createTaskWithBlankTitleReturnsBadRequest() throws Exception {
		String request = """
				{
					"title": " ",
					"description": "Sin título válido",
					"completed": false
				}
				""";

		mockMvc.perform(post("/api/task")
						.contentType(MediaType.APPLICATION_JSON)
						.content(request))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.error").value("Validación fallida"))
				.andExpect(jsonPath("$.detalles[0]", containsString("title")));
	}

	@Test
	void toggleTaskChangesCompletedStatus() throws Exception {
		Task task = taskRepository.save(new Task("Probar toggle", "Cambiar estado", false));

		mockMvc.perform(patch("/api/task/{id}/toggle", task.getId()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(task.getId()))
				.andExpect(jsonPath("$.completed").value(true));
	}

	@Test
	void deleteUnknownTaskReturnsNotFound() throws Exception {
		mockMvc.perform(delete("/api/task/{id}", 999L))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.error").value("Recurso no encontrado"));
	}
}
