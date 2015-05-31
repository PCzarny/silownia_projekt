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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	int userId;
	int trainingPlanId;
	Date startDate;
	Boolean isActive;
	
	
	
}
