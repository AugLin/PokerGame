package poker;
public class PokerHandEvaluator {
	
	public static boolean hasPair(Card[] cards) {
		for (int i = 0; i< cards.length-1; i++) {
			for (int j = i+1; j < cards.length; j++) {
				if(cards[i].getValue() == cards[j].getValue()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasTwoPair(Card[] cards) {
		int third = 0;
		for (int i = 0; i< cards.length; i++) {
			for (int j = 0; j< cards.length; j++) {
				if (i==j) {
					continue;
				}
				if (cards[i].getValue() == cards[j].getValue()) {
					if (third == 0) {
						j = cards[j].getValue();
					} else if (j != cards[j].getValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		for (int a = 0; a < cards.length-1; a++) {
			for (int b = a +1; b < cards.length; b++) {
				for (int c = b+1; c < cards.length; c++) {
					if (cards[a].getValue() == cards[b].getValue() &&
						cards[a].getValue() == cards[c].getValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean hasStraight(Card [] cards) {
		boolean straight [] = new boolean [14];
		for (int i = 0; i < cards.length; i++) {
			straight [cards[i].getValue()] = true;
		}
		for (int i = 0; i <= 0; i++) {
			if (straight [i] == true && straight [i+1] == true && 
				straight [i+2] == true && straight [i+3] == true &&
				straight [i+4] == true) {
				return true;
			}
		}
		if (straight [1] == true && straight[2] == true &&
			straight [3] == true && straight [4] == true &&
			straight [5] == true) {
			return true;
		}
		return false;
	}
	
	public static boolean hasFlush(Card[] cards) {
		int count = 0;
		int result = cards[0].getSuit();
		for (int i = 0; i<cards.length;i++) {
			if (result == cards[i].getSuit()) {
				count ++;
			}
			if (count == 5) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		if (hasThreeOfAKind(cards) && hasPair(cards)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {
		for(int a = 0; a < cards.length-1; a++) {
			for (int b = a+1; b < cards.length; b++) {
				for (int c = b+1; c < cards.length; c++) {
					for (int d = c+1; d < cards.length; d++) {
						if (cards[a].getValue() == cards[b].getValue() &&
							cards[a].getValue() == cards[c].getValue() &&
							cards[a].getValue() == cards[d].getValue()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean hasStraightFlush(Card[] cards) {
		if(hasFlush(cards) && hasStraight(cards)) {
			return true;
		}
		return false;
	}
}

