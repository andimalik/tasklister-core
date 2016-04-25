package com.andimalik.tasklister.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task implements Serializable {
	private static final long serialVersionUID = -8818002720993923205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TASK_NAME", length = 100, nullable = false)
	private String taskName = "";

	@Column(name = "TASK_DESCRIPTION", length = 200, nullable = false)
	private String taskDescription = "";

	@Column(name = "BEGIN_TIME", nullable = true)
	private Date beginTime;

	@Column(name = "END_TIME", nullable = true)
	private Date endTime;

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getTaskName() {
		return taskName;
	}

	public final void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public final String getTaskDescription() {
		return taskDescription;
	}

	public final void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public final Date getBeginTime() {
		return beginTime;
	}

	public final void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public final Date getEndTime() {
		return endTime;
	}

	public final void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
