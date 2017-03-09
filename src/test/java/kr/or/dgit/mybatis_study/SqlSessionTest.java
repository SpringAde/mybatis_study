package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class SqlSessionTest {
	private static SqlSessionFactory SqlSessionFactory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SqlSessionFactory=null;
	}

	@Test
	public void testSqlSession() {
		Assert.assertNotNull(SqlSessionFactory.openSession());
	}

}
