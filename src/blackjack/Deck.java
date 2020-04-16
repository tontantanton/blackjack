package blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	List<Card> ListOfCard = new ArrayList<Card>();

	public Deck() {
		this.resetDeck();
	}

	public void addCard(Card card) {
		this.ListOfCard.add(card);
	}

	public Card drawCard() {
		Card returnCard = getThisList().remove(getThisList().size() - 1);
		// getThisList().remove(getThisList().size()-1);
		return returnCard;
	}


	public void resetDeck() {
		this.ListOfCard.clear();
		for (int j = 0; j < 4; j++) {

			for (int i = 2; i <= 10; i++) {
				Card card = new Card(i + "", "Clubs");
				Card card2 = new Card(i + "", "Diamonds");
				Card card3 = new Card(i + "", "Hearts");
				Card card4 = new Card(i + "", "Spades");
				this.addCard(card);
				this.addCard(card2);
				this.addCard(card3);
				this.addCard(card4);
			}
		}
		this.addCard(new Card("A"+"", "Clubs"));
		this.addCard(new Card("J"+"", "Diamonds"));
		this.addCard(new Card("Q"+"", "Hearts"));
		this.addCard(new Card("K"+"", "Spades"));

	}

	private List<Card> getThisList() {
		return this.ListOfCard;
	}


	public void ShuffleCard() {
		List<Card> cards = getThisList();
		Collections.shuffle(cards);
		this.ListOfCard = cards;
	}

	public void printAllCard() {
		System.out.println("All Card In Deck Is : " + this.ListOfCard.size());
		for (int i = 0; i < ListOfCard.size(); i++) {
			System.out.println(this.ListOfCard.get(i).toString());
		}
	}

}
