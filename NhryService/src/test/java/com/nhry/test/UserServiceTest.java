package com.nhry.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nhry.service.auth.dao.UserService;
import com.nhry.service.basic.dao.BranchEmpService;

public class UserServiceTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] xmls = new String[]{ "classpath:spring-context.xml","classpath:dataSource.xml","classpath:*-bean.xml"  };
        ApplicationContext context = new ClassPathXmlApplicationContext(xmls);
        BranchEmpService emp = (BranchEmpService)context.getBean("branchService");
        emp.deleteBranchEmpByNo("11132");
	}

}
