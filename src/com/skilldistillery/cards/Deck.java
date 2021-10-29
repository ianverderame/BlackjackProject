package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = createDeck();

	}

	public List<Card> createDeck() {
		List<Card> fullDeck = new ArrayList<>();
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				fullDeck.add(new Card(ranks, suits));
			}
		}
		return fullDeck;
	}

	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;
	}

	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
	
}