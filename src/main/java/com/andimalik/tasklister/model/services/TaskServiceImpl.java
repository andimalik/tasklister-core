package com.andimalik.tasklister.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andimalik.tasklister.model.daos.TaskDao;
import com.andimalik.tasklister.model.entities.Task;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao taskDao;

	@Transactional
	@Override
	public void save(Task task) {
		this.taskDao.save(task);
	}

	@Transactional
	@Override
	public void update(Task task) {
		this.taskDao.update(task);
	}

	@Transactional
	@Override
	public void delete(Task task) {
		this.taskDao.delete(task);
	}

	@Transactional(readOnly = true)
	@Override
	public Task getTask(Integer id) {
		return this.taskDao.getTask(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Task> getTasks() {
		return this.taskDao.getTasks();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Task> getTasks(int offset, int limit) {
		return this.taskDao.getTasks(offset, limit);
	}

}
