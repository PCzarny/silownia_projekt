package model;

import java.sql.Date;
import java.util.ArrayList;

public class TrainingHistory {

	private int history_id ;
	private Date create_on;
	private int UserID; 
	private ArrayList<DoneExercise> doneExercises;
	public Date getCreate_on() {
		return create_on;
	}
	public void setCreate_on(Date create_on) {
		this.create_on = create_on;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public ArrayList<DoneExercise> getDoneExercises() {
		return doneExercises;
	}
	public void setDoneExercises(ArrayList<DoneExercise> doneExercises) {
		this.doneExercises = doneExercises;
	}
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	
}
