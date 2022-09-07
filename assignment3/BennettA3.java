package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class BennettA3 {

	public static void main(String[] args) throws IOException {

		BennettA3 bennettA3 = new BennettA3();
		bennettA3.work();
	}

	private void work() throws IOException {
		User[] users = new UserArrayService().parseFile("data.txt");
		Scanner scan = new Scanner(System.in);
		int fails = 0;
		User foundUser = null;
		while (fails <= 5 && foundUser == null) {
			System.out.println("Enter a Username: ");
			String username = scan.nextLine();
			System.out.println("Enter a Password");
			String password = scan.nextLine();
			foundUser = validate(username, password, users);
			if (foundUser != null) {
				System.out.println("Welcome " + foundUser.getName());
			} else {
				fails++;
				if (fails == 5) {
					System.out.println("Too many failed login attemps, you are now locked out.");
					System.exit(fails);
				} else
					System.out.println("Invalid login, please try again.");
			}

		}
		scan.close();
	}

	private User validate(String username, String password, User[] users) {
		for (User user : users) {
			if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {

				return user;

			}
		}
		return null;
	}
}
