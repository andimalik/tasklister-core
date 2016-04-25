package com.andimalik.tasklister.model.services;

import java.util.List;

import com.andimalik.tasklister.model.entities.Task;

public interface TaskService {
	public void save(Task task);

	public void update(Task task);

	public void delete(Task task);

	public Task getTask(Integer id);

	public List<Task> getTasks();

	public List<Task> getTasks(int offset, int limit);
}
