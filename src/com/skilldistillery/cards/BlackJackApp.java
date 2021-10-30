package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {
private static int numWins = 0;
private static int numLosses = 0;
private static int numTies = 0;
	
	public static void main(String[] args) {
		BlackJackApp bjApp = new BlackJackApp();
		bjApp.run();
		System.out.println("-----------------------------Final Score-----------------------------");
		System.out.println("Number of wins: " + numWins + "\tNumber of Ties: " + numTies + "\tNumber of Losses: " + numLosses);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;
		while (keepGoing) {
			Deck deck = new Deck();
			deck.shuffle();
			ArrayList<Card> playerHand = new ArrayList<>();
			ArrayList<Card> dealerHand = new ArrayList<>();
			Player player = new Player(playerHand);
			Dealer dealer = new Dealer(dealerHand);

			initialDeal(deck, playerHand, dealerHand);
			dealer.printInitialCards();
			player.printCards();

			playGame(deck, playerHand, player, dealer, dealerHand, sc);
			finalResult(deck, playerHand, player, dealer, dealerHand);
			keepGoing = playAgain(sc);
		}
		sc.close();
	}

	private void finalResult(Deck deck, ArrayList<Card> playerHand, Player player, Dealer dealer,
			ArrayList<Card> dealerHand) {
		
		System.out.println("\nPlayer total: " + player.getHandValue() + "\nDealer total: " + dealer.getHandValue());

		if (player.getHandValue() > 21) {
			System.out.println("Bust!!! Better luck next time");
			numLosses++;
		} else if (dealer.getHandValue() > 21) {
			System.out.println("You Win! Congratulations!");
			numWins++;
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Tie game!");
			numTies++;
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You Win! Congratulations!");
			numWins++;
		} else if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("Dealer Wins. Better luck next time");
			numLosses++;
		}
		System.out.println("Total number of wins: " + numWins + "\tTotal number of ties: " + numTies
				+ "\tTotal number of losses: " + numLosses);
	}

	private boolean playAgain(Scanner sc) {
		System.out.println("Would you like to play again?\n1. Yes\n2. No");
		int userInput = sc.nextInt();
		switch (userInput) {
		case 1:
			return true;
		case 2:
			System.out.println("Exiting program. Have a nice day");
			return false;
		default:
			return false;
		}
	}

	private void playGame(Deck deck, ArrayList<Card> playerHand, Player player, Dealer dealer,
			ArrayList<Card> dealerHand, Scanner sc) {
		boolean keepGoing = true;

		if (player.getHandValue() == 21) {
			keepGoing = false;
			System.out.println("Blackjack!!!!!");
		}

		while (keepGoing) {
			System.out.println("\nWhat would you like to do?\n1. Hit\n2. Stay");
			int userChoice = sc.nextInt();
			switch (userChoice) {
			case 1:
				int bust = addCard(deck, playerHand, player);
				if (bust < 0) {
					player.printCards();
					keepGoing = false;
					break;
				} else {
					player.printCards();
				}
				break;
			case 2:
				System.out.println("Player Stays...");
				dealer.printAllCards();
				dealerPlay(deck, dealerHand, dealer);
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter 1 or 2");
				break;
			}

		}
	}

	private void dealerPlay(Deck deck, ArrayList<Card> dealerHand, Dealer dealer) {
		boolean keepGoing = true;
		while (keepGoing) {
			if (dealer.getHandValue() > 21) {
				System.out.println("Dealer busts!");
				keepGoing = false;

			} else if (dealer.getHandValue() >= 17) {
				System.out.println("Dealer stays with a total of " + dealer.getHandValue());
				keepGoing = false;

			} else if (dealer.getHandValue() < 17) {
				System.out.println("Dealer hits!");
				dealerHand.add(deck.dealCard());
				dealer.printAllCards();
			}
		}
	}

	private void initialDeal(Deck deck, ArrayList<Card> playerHand, ArrayList<Card> dealerHand) {
		Card one = deck.dealCard();
		playerHand.add(one);
		Card two = deck.dealCard();
		dealerHand.add(two);
		Card three = deck.dealCard();
		playerHand.add(three);
		Card four = deck.dealCard();
		dealerHand.add(four);

		System.out.println("Dealing first card to Player..... " + one);
		System.out.println("Dealing first card to Dealer..... " + two);
		System.out.println("Dealing second card to Player....." + three);
		System.out.println("Dealing second card to Dealer..... Facedown");

	}

	private int addCard(Deck deck, ArrayList<Card> hand, Player player) {
		int i = 0;
		Card drawnCard = deck.dealCard();
		hand.add(drawnCard);
		if (player.getHandValue() > 21) {
			i = -1;
		} else
			i = 1;
		return i;
	}
}
