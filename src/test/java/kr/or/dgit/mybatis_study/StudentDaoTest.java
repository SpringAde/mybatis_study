package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

public class StudentDaoTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testSelectStudentByAll(){
		List<Student> lists = studentService.selectStudentByAll();
		for(Student s : lists){
			System.out.println(s);
		}
		Assert.assertNotNull(lists);
	}

}
