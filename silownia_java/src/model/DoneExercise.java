package model;

import java.sql.Date;

public class DoneExercise {
	
	private int done_exercise_id ;
	private Date created_on ;
	private int series; 
	private int values;
	private int exercise_id ;
	private String exercise_name;
	private int training_plan_id;
	private String training_plan_name;
	private int user_id;
	
	
	public int getDone_exercise_id() {
		return done_exercise_id;
	}
	public void setDone_exercise_id(int done_exercise_id) {
		this.done_exercise_id = done_exercise_id;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getValues() {
		return values;
	}
	public void setValues(int values) {
		this.values = values;
	}
	public int getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}
	public String getExercise_name() {
		return exercise_name;
	}
	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}
	public int getTraining_plan_id() {
		return training_plan_id;
	}
	public void setTraining_plan_id(int training_plan_id) {
		this.training_plan_id = training_plan_id;
	}
	public String getTraining_plan_name() {
		return training_plan_name;
	}
	public void setTraining_plan_name(String training_plan_name) {
		this.training_plan_name = training_plan_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
