package com.andimalik.tasklister;

import java.util.Date;
import java.util.List;

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

		Task newTask = new Task();
		newTask.setBeginTime(new Date());
		newTask.setEndTime(new Date());
		newTask.setTaskDescription("Description");
		newTask.setTaskName("Task Name");

		taskService.save(newTask);

		List<Task> list = taskService.getTasks();

		for (Task task : list) {
			System.out.println(task.getTaskName() + " ["
					+ task.getBeginTime().toString() + "] #"
					+ task.getId().toString() + "\n" + "    "
					+ task.getTaskDescription());
		}
	}
}
