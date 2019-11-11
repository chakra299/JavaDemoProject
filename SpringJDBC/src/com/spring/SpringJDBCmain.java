package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBCmain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

		SpringJDBCIMPL studentJDBCTemplate = (SpringJDBCIMPL) context.getBean("SpringJDBCIMPL");

		/*
		 * System.out.println("------Records Creation--------" );
		 * 
		 * studentJDBCTemplate.create("CHAKRA", 11);
		 * studentJDBCTemplate.create("PRINCE", 2);
		 * studentJDBCTemplate.create("SARADA ", 15);
		 */

		//studentJDBCTemplate.delete(2);
		//studentJDBCTemplate.update(3, 40);
		
		/*
		
		List<Student> listOfStudents=studentJDBCTemplate.listStudents();
		
		  for (Student student : listOfStudents) {
			  System.out.println( student.getId()+"\t" + student.getName()+"\t" + student.getAge());

		}
	*/
		
		Student student = studentJDBCTemplate.getStudent(4);
		 System.out.println( student.getId()+"\t" + student.getName()+"\t" + student.getAge());
	} 
}
