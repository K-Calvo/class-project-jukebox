package model;

import java.time.LocalDate;

// This class name is just a suggestion. 
// The account will need to use the type LocalDate
public class JukeboxAccount {

	private LocalDate today;
	private String username;
	private String password;
	private int songsSelectedToday;

	public JukeboxAccount(String usr, String pwd) {
		today = LocalDate.now();
		username = usr;
		password = pwd;
		songsSelectedToday = 0;
		System.out.println("Hey " + username + ", this is just a suggestion on " + today);
	}

	public Object songsSelectedToday() {
		return songsSelectedToday;
	}

	public void recordOneSelection() {
		if (today.isBefore(LocalDate.now())) {

			songsSelectedToday = 0; // 3 more songs
			today = LocalDate.now(); // new current day
			songsSelectedToday = songsSelectedToday + 1; // record a selection

		} else if (this.canSelect()) {
			songsSelectedToday = songsSelectedToday + 1;
		}

	}

	public boolean canSelect() {
		// if it's a new day, you get 3 more songs no matter what
		if (today.isBefore(LocalDate.now())) {
			return true;
		} else if (songsSelectedToday < 3) {
			return true;
		} else {
			return false;
		}
	}

	public void setAccountCreationDate(LocalDate date) {
		today = date;
	}

	public void pretendItsTomorrow() {
		today = today.plusDays(1);
		songsSelectedToday = 0; // 3 more songs
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
