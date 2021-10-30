package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Objects;

public abstract class BlackJackPlayer {
	private ArrayList<Card> hand = new ArrayList<Card>();

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackJackPlayer other = (BlackJackPlayer) obj;
		return Objects.equals(hand, other.hand);
	}

	public BlackJackPlayer(ArrayList<Card> hand) {
		super();
		this.hand = hand;
	}

	}
	
	
	
