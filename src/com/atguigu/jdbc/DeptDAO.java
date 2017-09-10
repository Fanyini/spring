package com.atguigu.jdbc;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO extends JdbcDaoSupport{
	
	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public Dept get(Integer id){
		String sql = "SELECT id, depeName from dept  where id = ?";
		RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}
}
