package com.mindtree.mobilestore.entity;

public class Mobile {
	private int modelId;
	private int operId;
	
	private String modelName;
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public int getOperId() {
		return operId;
	}
	public void setOperId(Oper operObj) {
		this.operId = operObj.getOperId();
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
}
