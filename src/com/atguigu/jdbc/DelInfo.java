package com.atguigu.jdbc;

public class DelInfo {
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private Dept dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "DelInfo [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dept=" + dept
				+ "]";
	}

}
