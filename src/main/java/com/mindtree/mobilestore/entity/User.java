package com.mindtree.mobilestore.entity;

public class User {
	private int userId;
	private String userName;
	private int modelId;
	private double cost;
	
/*	public User(int userId)
	{
		userId==userId;
		if(true)
		{
			int userId=10;
			userId=userId;
		}
	}*/
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(Mobile mobObj) {
		this.modelId = mobObj.getModelId();
	}
	
}
