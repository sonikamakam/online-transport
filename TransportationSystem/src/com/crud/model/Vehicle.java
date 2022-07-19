package com.crud.model;

public class Vehicle {
	
	public String vehicleNumber;
	public String vehicleType;
	public String fuelType;
	public String isInsuranced;
	public String permit;
	public String driverName;
	public String driverMobile;
	public String isAvailable;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vehicleNumber, String vehicleType, String fuelType,
			String isInsuranced, String permit, String driverName, String driverMobile, String isAvailable) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.isInsuranced = isInsuranced;
		this.permit = permit;
		this.driverName = driverName;
		this.driverMobile = driverMobile;
		this.isAvailable = isAvailable;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getIsInsuranced() {
		return isInsuranced;
	}

	public void setIsInsuranced(String isInsuranced) {
		this.isInsuranced = isInsuranced;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	

}
