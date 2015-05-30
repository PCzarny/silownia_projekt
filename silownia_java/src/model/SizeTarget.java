package model;

import java.sql.Date;

public class SizeTarget {

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getDimensionId() {
		return dimensionId;
	}
	public void setDimensionId(int dimensionId) {
		this.dimensionId = dimensionId;
	}
	public String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	
	private int userId;
	private int targetId;
	private int dimensionId;
	private String dimensionName;
	private int value;
	private String unit;
	private Date deadline;
	
}
