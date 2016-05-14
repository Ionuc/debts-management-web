package com.im.debtsmanagement.model;

public abstract class ManagementObject {

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract String getModelObjectDescription();
}
