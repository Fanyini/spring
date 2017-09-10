package com.atguigu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	private DelInfoDAO delInfoDAO;
	private DeptDAO deptDAO;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		context = new ClassPathXmlApplicationContext("jdbc_applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		delInfoDAO = context.getBean(DelInfoDAO.class);
		deptDAO = context.getBean(DeptDAO.class);
		namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
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
	
	/**
	 * 使用具名参数,可以为参数起名字
	 * 1、好处：若为多个参数，则不用再去对应位置，直接对应参数名，便于维护
	 * 2、缺点：较为麻烦
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO delinfo (NAME, phone, email, depeId) values(:name,:phone,:email,:deptId)";
		Map<String, Object> map = new HashMap<>();
		map.put("name", "GG");
		map.put("phone", "gg");
		map.put("email", "gg@qq.com");
		map.put("deptId", 1);
		namedParameterJdbcTemplate.update(sql, map);
	}
	/**
	 * 使用具名参数时，可已使用update(String sql, SqlParameterSource paramSource)方法进行更新操作
	 * 1、SQL语句中的参数名和类的属性名一致
	 * 2、使用SqlParameterSource 的 BeanPropertySqlParameterSource实现类作为参数
	 */
	@Test
	public void testNameParameterJdbcTemplate2(){
		String sql = "INSERT INTO delinfo (NAME, phone, email, depeId) values(:name,:phone,:email,:depeId)";
		
		DelInfo delInfo = new DelInfo();
		delInfo.setName("zxc");
		delInfo.setEmail("zxc@qq.com");
		delInfo.setPhone("aaaaa");
		delInfo.setId(5);
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(delInfo);
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}
	
}
