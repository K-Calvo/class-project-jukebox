package model;

/*
 * author: KIANNY CALVO
 * this class creates a user account with an user-name/ID and password.
 */

public class Account {

	private final String id; // the user's name
	private final String password;

	public Account(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getID() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	// update after Jukebox account merge
	public String toString() {
		return id + "\t" + password;
	}

}
