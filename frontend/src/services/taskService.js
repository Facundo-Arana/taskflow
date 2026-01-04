import axios from "axios";

const API_URL = "http://localhost:8080/api/task";

export const getAllTasks = async () => {
    try {
        return axios.get(API_URL);
    } catch(e) {
        console.log(e);    
    }
} 

export const createTask = (task) => axios.post(API_URL, task);

export const toggleTask = (id) => axios.patch(`${API_URL}/${id}/toggle`);

export const deleteTask = (id) => axios.delete(`${API_URL}/${id}`);

