import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL ?? "http://localhost:8080/api/task";

export const getAllTasks = () => axios.get(API_URL);

export const createTask = (task) => axios.post(API_URL, task);

export const toggleTask = (id) => axios.patch(`${API_URL}/${id}/toggle`);

export const deleteTask = (id) => axios.delete(`${API_URL}/${id}`);
