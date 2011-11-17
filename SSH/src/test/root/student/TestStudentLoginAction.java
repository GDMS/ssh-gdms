package test.root.student;

import static org.junit.Assert.fail;
import hibernate.tables.StudentDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * StudentLoginAction学生登录Action测试用例
 * 
 * @author LICH
 * 
 */
@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestStudentLoginAction extends AbstractJUnit4SpringContextTests {
	@Autowired
	private StudentDAO studentDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// do before Class
	}

	@BeforeTransaction
	public void verifyInitialDatabaseState() {
		// logic to verify the initial state before a transaction is started
	}

	@Before
	public void setUpTestDataWithinTransaction() {
		// set up test data within the transaction
		int num = studentDAO.findAll().size();
		boolean isReady = false;
		if (num > 0)
			isReady = true;
		Assert.assertTrue("数据库加载失败", isReady);
	}

	@Test
	// overrides the class-level defaultRollback setting
	@Rollback(true)
	public void testSample() {
		fail("Not yet implemented Sample");
	}

	@Test
	// overrides the class-level defaultRollback setting
	@Rollback(true)
	public void testExecute() {
		fail("Not yet implemented");
	}

	@After
	public void tearDownWithinTransaction() {
		// execute "tear down" logic within the transaction
	}

	@AfterTransaction
	public void verifyFinalDatabaseState() {
		// logic to verify the final state after transaction has rolled back
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// do after Class
	}
}
