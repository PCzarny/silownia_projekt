package model;

public class TrainingExercise extends Exercise {

	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getRepeats() {
		return repeats;
	}
	public void setRepeats(int repeats) {
		this.repeats = repeats;
	}
	public int getTrainingDayID() {
		return trainingDayID;
	}
	public void setTrainingDayID(int trainingDayID) {
		this.trainingDayID = trainingDayID;
	}
	int series;
	int repeats;
	int trainingDayID;
	
	
}
