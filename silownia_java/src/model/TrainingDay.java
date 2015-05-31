package model;

import java.util.ArrayList;

public class TrainingDay {
	
	public ArrayList<TrainingExercise> getExercises() {
		return exercises;
	}
	public void setExercises(ArrayList<TrainingExercise> exercises) {
		this.exercises = exercises;
	}
	public int getTrainingDayID() {
		return trainingDayID;
	}
	public void setTrainingDayID(int trainingDayID) {
		this.trainingDayID = trainingDayID;
	}
	public int getDayNr() {
		return dayNr;
	}
	public void setDayNr(int dayNr) {
		this.dayNr = dayNr;
	}
	public int getTrainingPlanID() {
		return trainingPlanID;
	}
	public void setTrainingPlanID(int trainingPlanID) {
		this.trainingPlanID = trainingPlanID;
	}
	ArrayList<TrainingExercise> exercises;
	int trainingDayID;
	int dayNr;
	int trainingPlanID;
	
}
