package com.atguigu.jdbc;

public class DelInfo {
	private Integer id;
	private String name;
	private String phone;
	private String email;
	private Integer depeId;

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

	public Integer getDepeId() {
		return depeId;
	}

	public void setDepeId(Integer depeId) {
		this.depeId = depeId;
	}

	@Override
	public String toString() {
		return "DelInfo [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", depeId=" + depeId
				+ "]";
	}

}
