package com.atguigu.jdbc;

public class Dept {
	private Integer id;
	private String depeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepeName() {
		return depeName;
	}

	public void setDepeName(String depeName) {
		this.depeName = depeName;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", depeName=" + depeName + "]";
	}

}
