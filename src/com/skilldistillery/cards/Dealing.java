package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Dealing dealing = new Dealing();
		dealing.run();
	}

	public void run() {
		Deck deck = new Deck();
		deck.shuffle();
		Scanner sc = new Scanner(System.in);
		List<Card> userHand = new ArrayList<>(); //not actually used, just have cards added to hand
		int handValue = 0;

		System.out.println("How many cards would you like? Please choose between 0-52");
		try {
				int userInput = sc.nextInt();
				if (!(userInput <= 52)) {
					throw new InputMismatchException();
				}
				if (userInput <= 52) {
					for (int i = 0; i < userInput; i++) {
						Card c = deck.dealCard();
						System.out.println(c);
						handValue += c.getValue();
						userHand.add(c); //not actually used, but a way to add to user's hand
					}
				}
			System.out.println("\nThis hand is equal to " + handValue);
		} catch (InputMismatchException e) {
			System.err.println("Please enter a number between 0 and 52. That's all that I have");
		} finally {
			sc.close();
		}
	}

}
