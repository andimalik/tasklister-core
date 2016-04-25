package com.andimalik.tasklister;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andimalik.tasklister.model.entities.Task;
import com.andimalik.tasklister.model.services.TaskService;

/**
 * Hello world!
 * 
 */
public class App {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		App.applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring-configuration.xml");
		TaskService taskService = (TaskService) App.applicationContext
				.getBean("taskService");

		Task task = new Task();
		task.setBeginTime(new Date());
		task.setEndTime(new Date());
		task.setTaskDescription("Description");
		task.setTaskName("Task Name");

		taskService.save(task);
	}
}
