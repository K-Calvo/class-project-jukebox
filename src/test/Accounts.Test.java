package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AccountsCollection;

class AccountsTest {

	AccountsCollection accounts = new AccountsCollection();

	@Test
	void testLogin() {
		accounts.createAccount("a", "aa");
		assertEquals("success", accounts.login("a", "aa"));
		assertEquals("incorrect password", accounts.login("a", "ab"));
		assertEquals("username not found", accounts.login("b", "aa"));
	}

	@Test
	void testCreate() {
		accounts.createAccount("a", "aa");
		assertEquals("Username already exist! Try a1", accounts.createAccount("a", "bb"));
		assertEquals("success", accounts.createAccount("b", "bb"));
	}

	@Test
	void accountsCollectionPersists() {
		AccountsCollection two = new AccountsCollection();
		accounts.createAccount("a", "aa");
		assertEquals("success", two.login("a", "aa"));
		assertEquals("Username already exist! Try a1", two.createAccount("a", "bb"));
	}
}
