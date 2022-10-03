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
			validateEmail("abc@yahoo.com");
			validateEmail("abc");
			validateEmail("abc-100@yahoo.com");
			validateEmail("abc@.com.my");
			validateEmail("abc.100@yahoo.com");
			validateEmail("abc123@gmail.a");
			validateEmail("abc111@abc.com");
			validateEmail("abc123@.com");
			validateEmail("abc-100@abc.net");
			validateEmail("abc123@.com.com");
			validateEmail("abc.100@abc.com.au");
			validateEmail(".abc@abc.com");
			validateEmail("abc@1.com");
			validateEmail("abc()*@gmail.com");
			validateEmail("abc@gmail.com.com");
			validateEmail("abc@%*.com");
			validateEmail("abc+100@gmail.com");
			validateEmail("abc..2002@gmail.com");
			validateEmail("abc.@gmail.com");
			validateEmail("abc@abc@gmail.com");
			validateEmail("abc@gmail.com.1a");
			validateEmail("abc@gmail.com.aa.au");
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

