package com.andimalik.tasklister.model.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.andimalik.tasklister.model.entities.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Task task) {
		this.sessionFactory.getCurrentSession().save(task);
	}

	@Override
	public void update(Task task) {
		this.sessionFactory.getCurrentSession().update(task);
	}

	@Override
	public void delete(Task task) {
		this.sessionFactory.getCurrentSession().delete(task);
	}

	@Override
	public Task getTask(Integer id) {
		return this.sessionFactory.getCurrentSession().get(Task.class, id);
	}

	@Override
	public List<Task> getTasks() {
		@SuppressWarnings("unchecked")
		List<Task> list = this.sessionFactory.getCurrentSession()
				.createCriteria(Task.class).list();
		return list;
	}

	@Override
	public List<Task> getTasks(int offset, int limit) {
		Criteria criteria = this.sessionFactory.getCurrentSession()
				.createCriteria(Task.class);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);

		@SuppressWarnings("unchecked")
		List<Task> list = criteria.list();

		return list;
	}

}
