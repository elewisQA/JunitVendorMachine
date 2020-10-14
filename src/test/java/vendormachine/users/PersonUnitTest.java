package vendormachine.users;

//===[ Imports ]===
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import vendormachine.users.util.Wallet;

//===[ Test Code ]===
public class PersonUnitTest {
	// Resources
	private int testCounter = 0;
	private Person person;
	private final String name = "Alice";

	// Report Resources
	private static ExtentReports report;
	private ExtentTest test;
	
	
	// Mocked Resources
	@Mock
	Wallet mockWallet;
	
	//--[ Test Setup ]---
	@BeforeAll
	public static void allInit() {
		// Set-up save paths
		Path root = FileSystems.getDefault()
				.getPath("")
				.toAbsolutePath();
		Path filePath= Paths.get(root.toString(), "\\target\\reports\\PersonUnitReport.html");
		
		// Initialise reporter
		report = new ExtentReports(filePath.toString(), true);
	}
	
	@BeforeEach
	public void eachInit() {
		testCounter++;
		this.person = new Person(this.name);
	}
	
	//-[ Constructor Tests ]-
	@Test
	public void oneArgConstructorTest() {
		// Begin Test
		test = report.startTest("oneArgConstructorTest");
		Person newPerson = new Person(this.name);
		
		// Log Assertions
		if(newPerson instanceof Person) {
			test.log(LogStatus.PASS, "Correct Instantiation "
					+ "- New object is an instance of Person class as expected");
		} else {
			test.log(LogStatus.FAIL, "Incorrect Instantiation "
					+ "- New object not an instance of Person class as expected");
		}
		// Test Assertion
		assertTrue(newPerson instanceof Person);
	}
	
	@Test
	public void allArgsConstructorTest() {
		// Begin Test
		test = report.startTest("allArgsConstructorTest");
				
		Person newPerson = new Person(this.name, this.mockWallet);
		
		// Log Assertions
		if(newPerson instanceof Person) {
			test.log(LogStatus.PASS, "Correct Instantiation "
					+ "- New object is an instance of Person class as expected");
		} else {
			test.log(LogStatus.FAIL, "Incorrect Instantiation "
					+ "- New object not an instance of Person class as expected");
		}
		// Test Assertion
		assertTrue(newPerson instanceof Person);
	}
	
	//-[ Wallet-related tests ]-
	@Test
	public void getCreditTest() {
		// Begin Test
		test = report.startTest("getCreditTest");
		
		// Set-up mockito conditions
		Wallet myWallet = Mockito.mock(Wallet.class);
		Mockito.when(myWallet.getCredit())
		.thenReturn(10.0f);
		Mockito.when(myWallet.takeCredit(5.0f))
		.thenReturn(5.0f);
		
		this.person.setWallet(myWallet);
		Float gottenCredit = this.person.getCredit(5.0f);

		// Log Assertion
		if (5.0f == gottenCredit) {
			test.log(LogStatus.PASS, "Correct value return "
					+ "- Credit value returned matches the expected");
		} else {
			test.log(LogStatus.FAIL, "Incorrect value return "
					+ "- Credit value returned doesn't match the expected");
		}
		// Test Assertion
		assertEquals(5.0f, 
				gottenCredit, 
				0.1f);
		Mockito.verify(myWallet).getCredit();
		Mockito.verify(myWallet).takeCredit(5.0f);
	}
	
	@Test
	public void addCreditTest() {
		// Begin Test
		test = report.startTest("addCredit");
		
		// Set-up mockito conditions
		Wallet myWallet = Mockito.mock(Wallet.class);
		Mockito.when(myWallet.getCredit())
		.thenReturn(15.0f);
		Mockito.when(myWallet.takeCredit(15.0f))
		.thenReturn(15.0f);
		
		this.person.setWallet(myWallet);
		this.person.addCredit(5.0f);
		
		// Log Assertion
		if (15.0f == this.person.getCredit(15.0f)) {
			test.log(LogStatus.PASS, "Correct value return "
					+ "- Credit value returned matches the expected");
		} else {
			test.log(LogStatus.FAIL, "Incorrect value return "
					+ "- Credit value returned doesn't match the expected");
		}
		// Test Assertion
		assertEquals(15.0f, this.person.getCredit(15.0f), 0.1f);
		Mockito.verify(myWallet).addCredit(5.0f);
	}
	
	// Getter & Setter Tests
	@Test
	void setNameTest() {
		// Begin Test
		test = report.startTest("setNameTest");
		
		String newName = "Alan";
		this.person.setName(newName);
		
		// Log Assertion
		if (newName.equals(this.person.getName())) {
			test.log(LogStatus.PASS, "Correct name setting - returned name matches set name");
		} else {
			test.log(LogStatus.FAIL, "Correct name setting - returned name matches set name");
		}
		// Test Assertion
		assertEquals(newName, this.person.getName());
	}
	
	@Test
	void getNameTest() {
		// Begin Test
		test = report.startTest("getNameTest");
		
		// Log Assertion
		if (this.name.equals(this.person.getName())) {
			test.log(LogStatus.PASS, "Correct name retrieval - returned name matches the expected");
		} else {
			test.log(LogStatus.FAIL, "Incorrect name retrieval - returned name does not match the expected");
		}
		// Test Assertion
		assertEquals(this.name, this.person.getName());
	}
	
	@Test
	void setGetWalletTest() {
		// Begin Test
		test = report.startTest("setGetWalletTest");
		
		Wallet newTestWallet = new Wallet();
		this.person.setWallet(newTestWallet);
		
		// Log Assertion
		if (newTestWallet.equals(this.person.getWallet())) {
			test.log(LogStatus.PASS, "Correct Value Returned");
		} else {
			test.log(LogStatus.FAIL, "Incorrect Value Returned - Doesn't Match Expected");
		}
		// Test Assertion
		assertEquals(newTestWallet, this.person.getWallet());
	}
	
	//--[ Test Closing ]--
	@AfterEach
	void eachTearDown() {
		report.endTest(test);
	}
	
	@AfterAll
	static void allTearDown() {
		// Finish up report stuff
		report.flush();
		report.close();
	}
}
