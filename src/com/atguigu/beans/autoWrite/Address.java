package com.atguigu.beans.autoWrite;

public class Address {
	private String city;
	private String stress;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStress() {
		return stress;
	}

	public void setStress(String stress) {
		this.stress = stress;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", stress=" + stress + "]";
	}

}
