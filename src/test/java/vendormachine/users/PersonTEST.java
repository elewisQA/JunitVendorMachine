package vendormachine.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendormachine.users.util.Wallet;

// Example 100% Person Test Coverage
// add @Ignore above class to help WalletTest.java
public class PersonTEST {	
	// Resources
	private Person person;
	private float credit = 10.0f;
	private Wallet testWallet;
	private final String name = "Alice";
	
	// Keep track of tests
	private static int activeTest = 1;
	private static StringBuilder sBuilder = new StringBuilder();
	private static String div = "=============================================\n";
	
	@BeforeEach
	public void init() {
		// Set-up resources
		this.testWallet = new Wallet();
		this.testWallet.setCredit(this.credit);
		this.person = new Person(this.name, this.testWallet);
		
		// Start of console test format
		sBuilder.setLength(0);
		sBuilder
		.append("\tTest ").append(activeTest).append("\n")
		.append(div)
		.append("Console:")
		.append("Starting Credit: ").append(testWallet.getCredit()).append("\n");
		
		System.out.println(sBuilder.toString());
		activeTest++;
		// End of console test format
	}
	
	// Constructor Test
	@Test
	public void test_Constructor() {
		// Constructor 1
		Person allan = new Person("Allan");
		assertTrue(allan instanceof Person);
		
		// Constructor 2 overload
		allan = new Person("Allan", testWallet);
		assertTrue(allan instanceof Person);
	}
	
	// Wallet-related tests
	@Test
	public void getCreditTest() {
		float result = this.person.getCredit(5.0f);
		
		assertEquals(5.0f, result, 0.1f);
	}
	
	@Test 
	public void addCreditTest() {
		this.person.addCredit(5.0f);
		
		assertEquals(15.0f, this.person.getCredit(15.0f), 0.1f);
	}
	
	// Getter & Setter tests
	@Test
	void setNameTest() {
		String newName = "Alan";
		this.person.setName(newName);
		assertEquals(newName, this.person.getName());
	}
	
	@Test
	void getNameTest() {
		assertEquals(this.name, this.person.getName());
	}
	
	@Test
	void setGetWalletTest() {
		Wallet newTestWallet = new Wallet();
		this.person.setWallet(newTestWallet);
		assertEquals(newTestWallet, this.person.getWallet());
	}
	
	@Test
	void getWalletTest() {
		assertEquals(this.testWallet, this.person.getWallet());
	}
	
	@Test
	public void test_noWallet() {
		// Generate example 'person' with no wallet
		Person alyx = new Person("Alyx");
		
		// Try to add credit to the person's wallet
		alyx.addCredit(10.0f);
		
		// Assert they have no wallet
		// And assert no credit can be drawn from the nonexistant wallet
		assertTrue(alyx.getWallet() == null);
		assertEquals(0, alyx.getCredit(5.0f), 0.1f);
	}
	
	@Test
	public void insufficientWalletFundsTest() {
		assertEquals(0f, this.person.getCredit(20.0f), 0.1f);
	}
	
	@AfterEach
	public void afterTest() {
		System.out.println(div);
	}
}
