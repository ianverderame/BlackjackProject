package com.skilldistillery.cards;

import java.util.ArrayList;

public class Player extends BlackJackPlayer {
	private int handValue = 0;

	public Player(ArrayList<Card> hand) {
		super(hand);
	}

	public void printCards() {
		handValue = 0;
		System.out.println("\n-----Player's Hand-----");
		for (Card card : getHand()) {
			System.out.println(card);
			handValue += card.getValue();
		}
		for (Card card : getHand()) {
			if ((card.getRank() == Rank.ACE ) && handValue > 21) {
				handValue -= 10;
			}
			}
		System.out.println("Total: " + handValue);
	}
	

	public int getHandValue() {
		handValue = 0;
		for (Card card : getHand()) {
			handValue += card.getValue();
			}
		for (Card card : getHand()) {
		if ((card.getRank() == Rank.ACE ) && handValue > 21) {
			handValue -= 10;
		}
		}
		return handValue;
	}




}
