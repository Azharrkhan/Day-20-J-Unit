package com.bl.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationJUnit {
	
		public static void main(String[] args) {
			System.out.println("Regular Expression program to validate User Registration!!!");
			UserRegistrationJUnit userEntry = new UserRegistrationJUnit();

			userEntry.testMails();
		}

		public void validateEntries() {
			System.out.println("Enter First Name :");
			validateName(getUserInput());

			System.out.println("Enter Last Name :");
			validateName(getUserInput());

			System.out.println("\nEnter Email Id : ");
			validateEmail(getUserInput());

			System.out.println("\nEnter Mobile Number : ");
			validateMobileNumber(getUserInput());
			
			System.out.println("\nEnter Password : ");
			validatePassword(getUserInput());

		}

		public String getUserInput() {
			Scanner sc = new Scanner(System.in);
			return sc.nextLine();
		}
		
		public void testMails() {
			validateEmail("xyz@yahoo.com");
			validateEmail("xyz");
			validateEmail("xyz-100@yahoo.com");
			validateEmail("xyz@.com.my");
			validateEmail("xyz.100@yahoo.com");
			validateEmail("xyz786@gmail.a");
			validateEmail("xyz123@abc.com");
			validateEmail("xyz786@.com");
			validateEmail("xyz-100@abc.net");
			validateEmail("xyz786@.com.com");
			validateEmail("xyz.100@abc.com.au");
			validateEmail(".xyz@abc.com");
			validateEmail("xyz@1.com");
			validateEmail("xyz()*@gmail.com");
			validateEmail("xyz@gmail.com.com");
			validateEmail("xyz@%*.com");
			validateEmail("abc+100@gmail.com");
			validateEmail("xyz..2002@gmail.com");
			validateEmail("xyz.@gmail.com");
			validateEmail("xyz@abc@gmail.com");
			validateEmail("xyz@gmail.com.1a");
			validateEmail("xyz@gmail.com.aa.au");
		}
		
		private void validatePassword(String input) {
			String password = "^(?=.*[A-Z])(?=.*[0-9])[0-9a-zA-Z]{8,}$";
			
			System.out.println("\nValidating Password...");
			match(password, input);
		}

		public void validateMobileNumber(String input) {

			String mobile = "^[0-9]{2}\\s[0-9]{10}$";

			System.out.println("\nValidating Mobile Number...");
			match(mobile, input);
		}

		public void validateEmail(String input) {

			String email = "^[0-9a-zA-Z]+([_+-.a-z0-9A-Z]+)*[@][a-zA-Z]+[.][a-z]{2,4}([.][a-z]{2})?$";

			System.out.println("\nValidating Email...");
			match(email, input);
		}

		public void validateName(String input) {

			String name = "^[A-Z][a-zA-Z]{3,}$";

			Pattern pattern = Pattern.compile(name);
			Matcher match = pattern.matcher(input);

			System.out.println("Validating Name...");
			printResult(match.matches(), input);

		}

		public void match(String regex, String input) {
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(input);

			printResult(match.matches(), input);
		}

		public void printResult(boolean isOk, String input) {
			if (isOk)
				System.out.println(" " + input + " is Valid");
			else
				System.out.println(" " + input + " is Invalid");
		}
	}

