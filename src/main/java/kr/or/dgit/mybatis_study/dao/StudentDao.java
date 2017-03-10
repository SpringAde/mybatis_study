package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {
	int insertStudent(Student student);
	
	int insertStudentWithPhone(Student student);		//typeHandlers 예제
	
	List<Student> selectStudentByAll();
	Student selectStudentByNo(int studNo);
	int updateStudent (Student student);
	int deleteStudentByNo(int studNo);
	 
}
