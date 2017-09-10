package com.atguigu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	private DelInfoDAO delInfoDAO;
	private DeptDAO deptDAO;
	{
		context = new ClassPathXmlApplicationContext("jdbc_applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		delInfoDAO = context.getBean(DelInfoDAO.class);
		deptDAO = context.getBean(DeptDAO.class);
	}

	/**
	 * 测试数据库是否连接成功
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	/**
	 * 执行 INSERT , UPDATE , DELETE
	 */
	@Test
	public void testUpdate() {
		String sql = "UPDATE delInfo set NAME = ?, email = ? WHERE id = ?";
		jdbcTemplate.update(sql, "aaa", "bbb", 1);
	}

	/**
	 * 执行批量更新：批量的 INSERT , UPDATE , DELETE 最后一个参数是Object[] 的list类型：
	 * 因为修改一条记录需要一个Object的数据，那么多条就需要多个Object的数组
	 */
	@Test
	public void testBunchUpdate() {
		String sql = "INSERT delInfo (NAME, phone, email) VALUES(?,?,?)";

		List<Object[]> list = new ArrayList<>();

		list.add(new Object[] { "AA", "aa", "aa@qq.com" });
		list.add(new Object[] { "BB", "bb", "bb@qq.com" });
		list.add(new Object[] { "CC", "cc", "cc@qq.com" });
		list.add(new Object[] { "DD", "dd", "dd@qq.com" });
		list.add(new Object[] { "EE", "ee", "ee@qq.com" });
		list.add(new Object[] { "FF", "ff", "ff@qq.com" });
		jdbcTemplate.batchUpdate(sql, list);
	}

	/**
	 * 从数据库中获取一条记录，实际得到对应的一个对象 注意 ： 不是调用queryForObject(String sql ,Class<DelInfo> requiredType, Object..args) 方法
	 *  而是调用 queryForObject(String sql, RowMapper<DelInfo> rowMapper, Object... args) 
	 *  1、其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper 
	 *  2、使用sql 中列的别名完成列名和类的属性名的映射，如： `NAME` AS name 
	 *  3、不支持级联属性， JdbcTemplate 是一个JDBC的小工具，而不是ORM框架
	 */
	@Test
	public void testQueryForObject() {
		String sql = "SELECT id, `NAME` AS name, phone, email, depeId as \"dept.id\" FROM delinfo WHERE id = ?";
		RowMapper<DelInfo> rowMapper = new BeanPropertyRowMapper<>(DelInfo.class);
		DelInfo delInfo = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(delInfo);
	}

	/**
	 * 查询实体类的集合 调用的不是queryForList
	 */
	@Test
	public void testQueryForList() {
		String sql = "SELECT id, `NAME` AS name, phone, email FROM delinfo WHERE id > ?";
		RowMapper<DelInfo> rowMapper = new BeanPropertyRowMapper<>(DelInfo.class);
		List<DelInfo> delInfos = jdbcTemplate.query(sql, rowMapper, 4);
		System.out.println(delInfos);
	}

	/**
	 * 查找实体类的集合 注意不是使用queryList 方法
	 * 而是使用 queryForObject(String sql, Class<Integer> requiredType)
	 */
	@Test
	public void testQueryForList2() {
		String sql = "select count(id) from delinfo";
		long count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	// 测试返回实体类
	@Test
	public void testDelInfos(){
		System.out.println(delInfoDAO.get(5));
	}
	
	@Test
	public void testDept(){
		System.out.println(deptDAO.get(1));
	}
}
