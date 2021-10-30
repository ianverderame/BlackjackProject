package com.skilldistillery.cards;

import java.util.ArrayList;

public class Dealer extends BlackJackPlayer{
	private int handValue = 0;
	
	public Dealer(ArrayList<Card> hand) {
		super(hand);
	}

	public void printAllCards() {
		handValue = 0;
		System.out.println("\n-----Dealer's Hand-----");
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
	
	public void printInitialCards() {
		System.out.println("\n-----Dealer's Hand-----");
			Card card = (getHand().get(0));
			System.out.println(card);
			System.out.println("\u2665\uFE0F \u2660\uFE0F Facedown \u2663\uFE0F \u2666\uFE0F");
			System.out.println("Total: " + card.getValue());
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