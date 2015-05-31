package model;

import java.sql.Date;
import java.util.ArrayList;

public class TrainingPlan {
	
//	private int day_nr; 
//	private int series;
//	private int value ; 
//	private String name;
	ArrayList <TrainingDay> trainingDays ;
//	private String description;
	private Date start_time;
	private int is_active;
	private int current_day;
	private int period;
	private int user_id;
	private int training_plan_id;
	private int owner;
	private String name;
	private int categoryId;
	private String categoryName;
//	private String url ;
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Date getStart_time() {
		return start_time;
	}
	
	
	public ArrayList<TrainingDay> getTrainingDays() {
		return trainingDays;
	}


	public void setTrainingDays(ArrayList<TrainingDay> trainingDays) {
		this.trainingDays = trainingDays;
	}


	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
	public int Is_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public int getCurrent_day() {
		return current_day;
	}
	public void setCurrent_day(int current_day) {
		this.current_day = current_day;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTraining_plan_id() {
		return training_plan_id;
	}
	public void setTraining_plan_id(int training_plan_id) {
		this.training_plan_id = training_plan_id;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	

}
