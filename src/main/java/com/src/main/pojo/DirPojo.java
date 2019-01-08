package com.src.main.pojo;

public class DirPojo {
	
	private String filePermission;
	private int filesAmount;
	private String owner;
	private String group;
	private String size;
	private String modifiedTime;
	private String name;
	
	public String getFilePermission() {
		return filePermission;
	}
	public void setFilePermission(String filePermission) {
		this.filePermission = filePermission;
	}
	public int getFilesAmount() {
		return filesAmount;
	}
	public void setFilesAmount(int filesAmount) {
		this.filesAmount = filesAmount;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
