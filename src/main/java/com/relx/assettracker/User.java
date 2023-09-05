package com.relx.assettracker;


public class User {
	
	private String associateID;
	private String associateName;
	private String location;
	private String Dept;
	private String environment;
	private String assetType;
	private String assetID;
	private String comments;


	public User() {
		super();
	}
	public User(String associateID, String associateName, String location, String Dept, String environment, String assetType,String assetID,String comments) {
		super();
		this.associateID = associateID;
		this.associateName = associateName;
		this.location = location;
		this.Dept = Dept;
		this.environment = environment;
		this.assetType = assetType;
		this.assetID = assetID;
		this.comments = comments;
	}
	public String getFirstName() {
		return associateID;
	}
	public void setAssociateID(String associateID) {
		this.associateID = associateID;
	}
	public String getLastName() {
		return associateName;
	}
	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}
	public String getAddress() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return Dept;
	}
	public void setDept(String Dept) {
		this.Dept = Dept;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetID() {
		return assetID;
	}
	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) { this.comments = comments;  }
	@Override
	public String toString() {
		return "User [firstName=" + associateID + ", lastName=" + associateName + ", address=" + location + ", email=" + Dept
				+ ", environment=" + environment+ ", assetType=" + assetType+ ", assetID=" + assetID+ ", comments=" + comments+ "]";
	}
	
	

}
