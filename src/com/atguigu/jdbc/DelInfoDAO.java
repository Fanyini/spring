package com.atguigu.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DelInfoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 返回一个实体类，这样是线程安全的
	public DelInfo get(Integer id){
		String sql = "SELECT id, `NAME` AS name, phone, email, depeId as \"dept.id\" FROM delinfo WHERE id = ?";
		RowMapper<DelInfo> rowMapper = new BeanPropertyRowMapper<>(DelInfo.class);
		DelInfo delInfo = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return delInfo;
	}
}
