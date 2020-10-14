package vendormachine.vendors.item;

//===[ Imports ]===
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//===[ Test Definition ]===
public class SnackTEST {
	// Test Variables
	private Snack snack;
	private final Float cost = 5.0f;
	
	//--[ Test Setup ]--
	@BeforeEach
	void init() {
		this.snack = new Snack(cost);
	}

	//--[ Tests ]--
	@Test
	void snackCostTest() {
		assertEquals(this.cost, this.snack.cost());
	}
	
	@Test
	void snackSetValueTest() {
		Float newCost = 6.0f;
		this.snack.setValue(newCost);
		assertEquals(newCost, this.snack.cost());
	}
}
