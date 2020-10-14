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
	
	// Constructor tests
	@Test
	void oneArgTest() {
		this.wallet = new Wallet(this.amount);
		// User getter to test working properly
		assertEquals(this.amount, this.wallet.getCredit());
	}
	
	@Test
	void allArgTest() {
		this.wallet = new Wallet(this.brand, this.amount);
		// Use getters to test working properly
		assertEquals(this.amount, this.wallet.getCredit());
		assertEquals(this.brand, this.wallet.getBrand());
	}
	
	// Credit method tests
	@Test
	void addCreditTest() {
		Float addAmount = 5f;
		this.wallet.addCredit(addAmount);
		assertEquals(this.amount + addAmount,
				this.wallet.getCredit());
	}
	
	
	@Test
	void takeCreditTest() {
		Float takeAmount = 5f;
		// Starting amount is 10
		// Assert remaining amount is 5 after removing 5
		assertEquals(takeAmount,
				this.wallet.takeCredit(takeAmount));
	}
	
	//--[ Getter & Setter Tests ]--
	@Test
	void getCreditTest() {
		assertEquals(this.amount, 
				this.wallet.getCredit());
	}
	
	@Test
	void getBrandTest() {
		assertEquals(this.brand, 
				this.wallet.getBrand());
	}
	
	@Test
	void setBrandTest() {
		String newBrand = "FatFace";
		this.wallet.setBrand(newBrand);
		assertEquals(newBrand, this.wallet.getBrand());
	}
}
