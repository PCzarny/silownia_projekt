package model;

import java.sql.Date;

public class Dimension {
	
	private int user_dimension_id; 
	private int dimension_id;
	private String name ;
	private int value;
	private String unit;
	private int user_id;
	private Date created_on;
	public int getDimension_id() {
		return dimension_id;
	}
	public void setDimension_id(int dimension_id) {
		this.dimension_id = dimension_id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public int getUser_dimension_id() {
		return user_dimension_id;
	}
	public void setUser_dimension_id(int user_dimension_id) {
		this.user_dimension_id = user_dimension_id;
	}
	
}
