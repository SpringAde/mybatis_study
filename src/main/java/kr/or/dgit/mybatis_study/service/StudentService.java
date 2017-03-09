package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance= new StudentService();
	public static StudentService getInstance() {
		return instance;
	}
	private StudentService() {	}
	
	public List<Student> selectStudentByAll(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);		// 인터페이스와 매핑해서 해당 메소드 찾아준다.
//		sqlSession.close();
		return studentDao.selectStudentByAll();		//맵퍼의 id로 sql문장을 가져온다.		
	}
	
}
