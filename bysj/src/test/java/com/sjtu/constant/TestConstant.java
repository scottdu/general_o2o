package com.sjtu.constant;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context.xml")
public class TestConstant {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Constant.GetParameters();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_001_logback() {
		Logger LOGGER = LoggerFactory.getLogger(TestConstant.class);
		LOGGER.info("---------info---------");
		LOGGER.debug("---------debug-------");
		LOGGER.trace("---------trace-------");
		LOGGER.error("---------error-------");
		LOGGER.warn("---------warn---------");
	}

}
