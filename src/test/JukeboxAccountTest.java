package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.JukeboxAccount;


class JukeboxAccountTest {

	@Test
	void testGetters() {
		JukeboxAccount aJBA = new JukeboxAccount("Username", "password");
		assertEquals("Username", aJBA.getUsername());
		assertEquals("password", aJBA.getPassword());

	}

	@Test
	public void testChangeOfDateWithAFewTimes() {

		JukeboxAccount user = new JukeboxAccount("Casey", "1111");
		assertEquals(0, user.songsSelectedToday());
		user.recordOneSelection();
		assertEquals(1, user.songsSelectedToday());
		user.recordOneSelection();
		assertTrue(user.canSelect());
		user.recordOneSelection();
		assertEquals(3, user.songsSelectedToday());
		assertFalse(user.canSelect());

		user.pretendItsTomorrow(); // Uses a LocalDate instance variable
		
		assertEquals(0, user.songsSelectedToday());
		user.recordOneSelection();
		user.recordOneSelection();
		assertTrue(user.canSelect());
		user.recordOneSelection();
		assertEquals(3, user.songsSelectedToday());
		assertFalse(user.canSelect());

	}
	
	@Test
	public void testDayChange() {
		JukeboxAccount user = new JukeboxAccount("Casey", "1111");
		user.setAccountCreationDate(LocalDate.now().minusDays(1));
		assertTrue(user.canSelect());
		user.recordOneSelection();
	}

}
