package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/* Author: KIANNY CALVO
 * This class manages a collection account objects. It allows for logins/ 
 * accessing an account and creating a new account with a unique ID.
 */

//must change load and save to serialization

public class AccountsCollection {

	private static HashMap<String, Account> accounts = new HashMap<>();

	public AccountsCollection() {

	}

	// this method takes a name and password string to find an existing account
	public String login(String name, String password) {
		if (accounts.containsKey(name)) { // checks for existence of a username
			// verifies the password
			if (accounts.get(name).getPassword().equals(password)) {
				return "success";
			}
			return "incorrect password";
		}
		return "username not found";
	}

	// this method creates a new account, and ensures a unique user ID
	public String createAccount(String name, String password) {
		if (!(accounts.containsKey(name))) { // check if name is unique
			Account newUser = new Account(name, password);
			accounts.put(name, newUser);
			return "success";
		}
		// provides an alternative name for the user that is unique
		String makeUnique = name + Integer.toString(accounts.size());
		return "Username already exist! Try " + makeUnique;
	}

	public Account getAccount(String name) {
		return accounts.get(name);
	}

	// this method saves users accounts
	public void save(boolean addOrNot) {
		try {
			BufferedWriter writer;
			if (addOrNot) {
				writer = new BufferedWriter(new FileWriter("accountsFile.txt", true));
				writer.newLine();
			} else {
				writer = new BufferedWriter(new FileWriter("accountsFile.txt", false));
			}
			for (HashMap.Entry<String, Account> entry : accounts.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				writer.write(key + "\t" + value.toString());
				writer.newLine();
			}
			writer.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// this method loads user accounts from a file
	public boolean load() {
		try {
			Scanner fileIn = new Scanner(new File("accountsFile.txt"));
			while (fileIn.hasNext()) {
				String cur = fileIn.nextLine();
				if (cur.isEmpty()) {
					continue;
				}
				String[] entry = cur.split("\t"); // array of key value pair
				accounts.put(entry[0], new Account(entry[1], entry[2]));
			}
			fileIn.close();
			return true;
		} catch (IOException e) {
			System.out.println("No Accounts Exists!");
			return false;
		}
	}
}
