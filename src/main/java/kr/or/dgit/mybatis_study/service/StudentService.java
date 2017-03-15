package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService{
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
	
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.insertStudent(student);
		sqlSession.commit();		// commit이 빠지면 테스트는 되지만, 실제 sql은 작동 안함. 반드시 commit실행해야 적용
		return res;
	}
	
	public int insertStudentWithPhone(Student student){
		int res = -1;		// 성공실패를 판단하기 위한 -1
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){		// 이렇게 하면 finally close()안하고 자동으로 close()호출된다.
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertStudentWithPhone(student);
			sqlSession.commit();
		} catch(Exception e){
			e.printStackTrace();
		} 
		return res;
	}
	
	public Student selectStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);		
		return studentDao.selectStudentByNo(studNo);		
	}
	
	public int updateStudent(Student student) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.updateStudent(student);
		sqlSession.commit();
		return res;
	}
	
	public int deleteStudentByNo(int studNo) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.deleteStudentByNo(studNo);
		sqlSession.commit();
		return res;
	}	
}
