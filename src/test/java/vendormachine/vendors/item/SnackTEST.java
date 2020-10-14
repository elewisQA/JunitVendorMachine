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
	void getPriceTest() {
		assertEquals(this.cost, this.snack.getPrice());
	}
	
	@Test
	void setPriceTest() {
		Float newCost = 6.0f;
		this.snack.setPrice(newCost);
		assertEquals(newCost, this.snack.getPrice());
	}
	
	@Test
	void allArgsConstructorTest() {
		String name = "Snickers";
		Snack newSnack = new Snack(name, this.snack.getPrice());
	}
}
