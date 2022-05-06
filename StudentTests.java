package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	private Card[] cards;
	@Test
	public void test() {
		this.cards = new Card[52];
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck);
	}
	@Test
	public void test2() {

	}
}