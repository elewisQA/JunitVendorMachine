package vendormachine.vendors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTEST {
	// Test Variables
	private DefaultSnacks snackList;
	private DrinkVendingMachine machine;
	private final Float credit = 0f;
	private final String userName = "Alice";
	private Wallet userWallet;
	private Person user;
	
	// Keep track of tests
	private static int activeTest = 1;
	private static StringBuilder sBuilder = new StringBuilder();
	private static String div = "=============================================\n";

	@BeforeEach
	void init() {
		// Initialise new machine using zero-args constructor
		this.machine = new DrinkVendingMachine();
		
		// Build up this user
		this.userWallet = new Wallet();
		this.userWallet.setCredit(credit);
		this.user = new Person(this.userName, 
				this.userWallet);
		
		// Start of console test format
		sBuilder.setLength(0);
		sBuilder
		.append("\tTest ").append(activeTest).append("\n")
		.append(div);
		// Append info about vending machine here
		
		System.out.println(sBuilder.toString());
		activeTest++;
		// End of console test format
	}
	
	@Test
	void giveCredit() {
		this.machine.giveCredit(this.user, this.credit);
		// Pass if there's no crash
	}
	
	@Test
	void giveNegativeCredit() {
		// TODO assert some failure condition
		this.machine.giveCredit(this.user, -10f);
	}
	
	@Test
	void selectDrinkTest() {
		int index = 1;
		Float creditAmount = 10f;
		this.user.addCredit(creditAmount);
		// Give credit to make a selection
		this.machine.giveCredit(this.user, creditAmount);
		assertEquals(snackList.snackList[index],
				this.machine.selectDrink(index));
	}
	
	@Test
	void insufficientCreditSelectDrinkTest() {
		int index = 1;
		// Try to make selection
		this.machine.giveCredit(user, credit);
		assertEquals(null,
				this.machine.selectDrink(index));
	}
	
	@Test
	void selectNullDrinkTest() {
		int index = 0;
		// Give credit to make a selection
		this.machine.giveCredit(user, credit);
		assertEquals(null,
				this.machine.selectDrink(index));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println(div);
	}
}
