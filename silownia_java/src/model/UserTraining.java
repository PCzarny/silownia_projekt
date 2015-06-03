package model;

import java.sql.Date;

public class UserTraining {

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTrainingPlanId() {
		return trainingPlanId;
	}
	public void setTrainingPlanId(int trainingPlanId) {
		this.trainingPlanId = trainingPlanId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	int userId;
	int trainingPlanId;
	Date startDate;
	int isActive;
	int currentDay;
	
	
	
}
