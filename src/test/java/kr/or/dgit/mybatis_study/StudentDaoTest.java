package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.util.Date;
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
/*	
	@Test
	public void testInsertStudent(){
		Student student = new Student(4, "라라라", "lala@test.co.kr", new Date());
		int res = studentService.insertStudent(student);
		
		Assert.assertEquals(1, res);		// 1과 같아야 성공 (Updates: 1)
	}
	*/
/*	@Test
	public void testselectStudentByNo(){
		Student student = studentService.selectStudentByNo(1);
		Assert.assertNotNull(student);
	}*/
	
	@Test
	public void testUpdateStudentByNo(){
		Student student = studentService.selectStudentByNo(3);
		Assert.assertNotNull(student);
	}
	
	@Test
	public void testDeleteStudent(){
		int studNo = studentService.deleteStudentByNo(2);
		int res = studentService.deleteStudentByNo(studNo);
		Assert.assertEquals(1, res);		
	}
	

}
