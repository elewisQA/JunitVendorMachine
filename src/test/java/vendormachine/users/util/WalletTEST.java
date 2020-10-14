package vendormachine.users.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTEST {
	// Test Variables
	private Wallet wallet;
	private final Float amount = 10f;
	private final String brand = "Gucci";
	
	//--[ Test Setup ]--
	@BeforeEach
	void init() {
		this.wallet = new Wallet();
		this.wallet.setCredit(amount);
		this.wallet.setBrand(brand);
	}
	
	//--[ Tests ]--
	@Test
	void getAllCreditTest() {
		assertEquals(this.amount, 
				this.wallet.getAllCredit());
	}
	
	@Test
	void getCreditTest() {
		Float subAmount = 5f;
		// Starting amount is 10
		// Assert remaining amount is 5 after removing 5
		assertEquals(subAmount,
				this.wallet.getCredit(subAmount));
	}
	
	@Test
	void addCreditTest() {
		Float addAmount = 5f;
		this.wallet.addCredit(addAmount);
		assertEquals(this.amount + addAmount,
				this.wallet.getAllCredit());
	}
	
	@Test
	void getBrandTest() {
		assertEquals(this.brand, 
				this.wallet.getBrand(this.brand));
	}
	
	@Test
	void setBrandTest() {
		String newBrand = "FatFace";
		this.wallet.setBrand(newBrand);
		assertEquals(newBrand, this.wallet.getBrand(newBrand));
	}
}
