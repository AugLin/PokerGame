package poker;

public class Deck {

	private Card[] cards;
	public Deck() {
		this.cards = new Card[52];
		int i = 0;
			for (int suit = 0; suit <=3; suit ++) {
				for (int value = 1; value <= 13; value ++) {
					this.cards[i] = new Card (value,suit);
					i++;
			}
		}
	}

	public Deck(Deck other) {
		this.cards = other.cards;
	}

	public Card getCardAt(int position) {
		int value = cards[position].getValue();
		int suit = cards[position].getSuit();
		Card x = new Card(value, suit);

		return x;
	}

	public int getNumCards() {
		return cards.length;
	}

	public void shuffle() {
		Card[] top;
		if (cards.length %2 == 0) {
			top = new Card[cards.length / 2];
		} else {
			top = new Card[cards.length /2 + 1];
		}
		for (int i = 0; i < top.length; i++) {
			top[i] = cards[i];
		}
		Card [] bottom;
		bottom = new Card [cards.length /2];

		int count = top.length;

		for (int i = 0; i < bottom.length; i++) {
			bottom[i] = cards[count];
			count ++;
		}
		int a=0,b=0;
		for (int i = 0; i < cards.length; i++) {
			if (i%2 ==0) {
				cards[i] = top[a];
				a++;
			} else {
				cards[i] = bottom[b];
				b++;
			}
		}
	}

	public void cut(int position) {
		int x = 0;
		Card[] top = new Card[position];
		for(int i = 0; i < top.length; i++) {
			top[i] = cards[i];
		}
		Card[] bottom = new Card [cards.length - top.length];
		int count = position;
		for (int i = 0; i < bottom.length; i++) {
			bottom[i] = cards[count];
			count ++;
		}
		for (int i = 0; i < cards.length; i++) {
			if (i < bottom.length) {
				cards[i] = bottom[i];
			} else {
				cards[i] = top[x];
				x++;
			}
		}
	}

	public Card[] deal(int numCards) {
		Card[] dealt = new Card[numCards];
		for (int i = 0; i < dealt.length; i++) {
			dealt[i] = cards[i];
		}

		Card[] shorter = new Card[cards.length - numCards];
		for (int i = 0; i < shorter.length; i++) {
			shorter[i] = cards[numCards];
			numCards++;
		}

		cards = new Card[shorter.length];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = shorter[i];
		}

		return dealt;
	}

}
