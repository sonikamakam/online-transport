package com.crud.model;

public class Manager {
	
	private String managerName;
	private String managerBranch;
	private String managerRole;
	
	public Manager() {
		super();
	}

	public Manager(String managerName, String managerBranch, String managerRole) {
		super();
		this.managerName = managerName;
		this.managerBranch = managerBranch;
		this.managerRole = managerRole;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerBranch() {
		return managerBranch;
	}

	public void setManagerBranch(String managerBranch) {
		this.managerBranch = managerBranch;
	}

	public String getManagerRole() {
		return managerRole;
	}

	public void setManagerRole(String managerRole) {
		this.managerRole = managerRole;
	}
	
}
