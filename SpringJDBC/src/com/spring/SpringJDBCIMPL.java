package com.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBCIMPL implements SpringJDBCinterface {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer age) {

		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());

		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;

	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		int result = jdbcTemplateObject.update(SQL, id);
		if (result > 0) {
			System.out.println("Deleted Record with ID = " + id);
		} else {
			System.out.println("No record found");
		}
	}

	@Override
	public void update(Integer id, Integer age) {

		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

}
