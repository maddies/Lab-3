package pkgCore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import antlr.collections.List;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void TestIsRoyalFlush() {
		ArrayList<Card> cards = new ArrayList<Card>();
		cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.HEARTS, eRank.KING),
				new Card(eSuit.HEARTS, eRank.QUEEN), new Card(eSuit.HEARTS, eRank.JACK),
				new Card(eSuit.HEARTS, eRank.TEN));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);

		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isRoyalFlush());
	}

	@Test
	public void TestIsStraightFlush() {
		ArrayList<Card>	cards = asList(new Card(eSuit.HEARTS, eRank.SIX), 
				new Card(eSuit.HEARTS, eRank.FIVE), new Card(eSuit.HEARTS, eRank.FOUR),
				new Card(eSuit.HEARTS, eRank.THREE), new Card(eSuit.HEARTS, eRank.TWO));
		
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;
		assertTrue(bExpectedAnswer == h.isStraightFlush());
	}
	
	@Test
	public void TestIsFourOfAKind1234() {

		ArrayList<Card> cards = asList(new Card(eSuit.CLUBS, eRank.TEN), new Card(eSuit.HEARTS, eRank.TEN),
				new Card(eSuit.SPADES, eRank.TEN), new Card(eSuit.DIAMONDS, eRank.TEN),
				new Card(eSuit.HEARTS, eRank.TWO));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isFourOfAKind());
	}

	@Test
	public void TestIsFourOfAKind2345() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.HEARTS, eRank.EIGHT),
				new Card(eSuit.CLUBS, eRank.EIGHT), new Card(eSuit.DIAMONDS, eRank.EIGHT),
				new Card(eSuit.SPADES, eRank.EIGHT));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isFourOfAKind());
	}

	@Test
	public void TestIsFullHouse32() {

		ArrayList<Card> cards = asList(new Card(eSuit.DIAMONDS, eRank.FIVE), new Card(eSuit.HEARTS, eRank.FIVE),
				new Card(eSuit.SPADES, eRank.FIVE), new Card(eSuit.CLUBS, eRank.THREE),
				new Card(eSuit.SPADES, eRank.THREE));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isFullHouse());
	}

	@Test
	public void TestIsFullHouse23() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.QUEEN), new Card(eSuit.SPADES, eRank.QUEEN),
				new Card(eSuit.HEARTS, eRank.JACK), new Card(eSuit.SPADES, eRank.JACK),
				new Card(eSuit.CLUBS, eRank.JACK));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isFullHouse());
	}

	@Test
	public void TestIsFlush() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.HEARTS, eRank.KING),
				new Card(eSuit.HEARTS, eRank.QUEEN), new Card(eSuit.HEARTS, eRank.JACK),
				new Card(eSuit.HEARTS, eRank.TEN));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isFlush());
	}

	@Test
	public void TestIsStraight() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.TEN), new Card(eSuit.CLUBS, eRank.NINE),
				new Card(eSuit.HEARTS, eRank.EIGHT), new Card(eSuit.SPADES, eRank.SEVEN),
				new Card(eSuit.DIAMONDS, eRank.SIX));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isStraight());
	}

	@Test
	public void TestIsStraight_highace() {
		ArrayList<Card>	cards = asList(new Card(eSuit.SPADES, eRank.ACE), 
				new Card(eSuit.DIAMONDS, eRank.KING), new Card(eSuit.CLUBS, eRank.QUEEN),
				new Card(eSuit.SPADES, eRank.JACK), new Card(eSuit.SPADES, eRank.TEN));
		
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;
		assertTrue(bExpectedAnswer == h.isStraight());
	}

	@Test
	public void TestIsStraight_lowace() {
		ArrayList<Card>	cards = asList(new Card(eSuit.HEARTS, eRank.ACE), 
				new Card(eSuit.SPADES, eRank.FIVE), new Card(eSuit.HEARTS, eRank.FOUR),
				new Card(eSuit.DIAMONDS, eRank.THREE), new Card(eSuit.CLUBS, eRank.TWO));

		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;
		assertTrue(bExpectedAnswer == h.isStraight());
	}
	
	@Test
	public void TestIsThreeOfAKind123() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.CLUBS, eRank.ACE),
				new Card(eSuit.SPADES, eRank.ACE), new Card(eSuit.DIAMONDS, eRank.JACK),
				new Card(eSuit.HEARTS, eRank.TEN));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer = h.isThreeOfAKind());
	}

	@Test
	public void TestIsThreeOfAKind234() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.CLUBS, eRank.KING),
				new Card(eSuit.SPADES, eRank.KING), new Card(eSuit.DIAMONDS, eRank.KING),
				new Card(eSuit.HEARTS, eRank.TEN));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isThreeOfAKind());
	}

	@Test
	public void TestIsThreeOfAKind345() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.CLUBS, eRank.KING),
				new Card(eSuit.SPADES, eRank.EIGHT), new Card(eSuit.DIAMONDS, eRank.EIGHT),
				new Card(eSuit.HEARTS, eRank.EIGHT));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isThreeOfAKind());
	}

	@Test
	public void TestIsTwoPair1234() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.EIGHT), new Card(eSuit.CLUBS, eRank.EIGHT),
				new Card(eSuit.SPADES, eRank.SEVEN), new Card(eSuit.DIAMONDS, eRank.SEVEN),
				new Card(eSuit.HEARTS, eRank.TWO));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isTwoPair());
	}

	@Test
	public void TestIsTwoPair2345() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.QUEEN), new Card(eSuit.CLUBS, eRank.JACK),
				new Card(eSuit.SPADES, eRank.JACK), new Card(eSuit.DIAMONDS, eRank.NINE),
				new Card(eSuit.HEARTS, eRank.NINE));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isTwoPair());
	}

	@Test
	public void TestIsTwoPair1245() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.KING), new Card(eSuit.CLUBS, eRank.KING),
				new Card(eSuit.SPADES, eRank.TEN), new Card(eSuit.DIAMONDS, eRank.EIGHT),
				new Card(eSuit.HEARTS, eRank.EIGHT));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isTwoPair());
	}

	@Test
	public void TestIsPair12() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.KING), new Card(eSuit.CLUBS, eRank.KING),
				new Card(eSuit.SPADES, eRank.TEN), new Card(eSuit.DIAMONDS, eRank.SIX),
				new Card(eSuit.HEARTS, eRank.FOUR));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isPair());
	}

	@Test
	public void TestIsPair23() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.ACE), new Card(eSuit.CLUBS, eRank.NINE),
				new Card(eSuit.SPADES, eRank.NINE), new Card(eSuit.DIAMONDS, eRank.SEVEN),
				new Card(eSuit.HEARTS, eRank.FIVE));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isPair());
	}

	@Test
	public void TestIsPair34() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.EIGHT), new Card(eSuit.CLUBS, eRank.SIX),
				new Card(eSuit.SPADES, eRank.THREE), new Card(eSuit.DIAMONDS, eRank.THREE),
				new Card(eSuit.HEARTS, eRank.TWO));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isPair());
	}

	@Test
	public void TestIsPair45() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.KING), new Card(eSuit.CLUBS, eRank.TEN),
				new Card(eSuit.SPADES, eRank.SIX), new Card(eSuit.DIAMONDS, eRank.FOUR),
				new Card(eSuit.HEARTS, eRank.FOUR));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isPair());
	}

	@Test
	public void TestIsHighCard() {

		ArrayList<Card> cards = asList(new Card(eSuit.HEARTS, eRank.QUEEN), new Card(eSuit.CLUBS, eRank.NINE),
				new Card(eSuit.SPADES, eRank.SEVEN), new Card(eSuit.DIAMONDS, eRank.FOUR),
				new Card(eSuit.HEARTS, eRank.THREE));
		HandPoker h = new HandPoker();
		for (Card card : cards)
			h.AddCard(card);
		boolean bExpectedAnswer = true;

		assertTrue(bExpectedAnswer == h.isHighCard());
	}

	private ArrayList<Card> asList(Card card, Card card2, Card card3, Card card4, Card card5) {
		ArrayList<Card> list = new ArrayList<Card>();
		list.add(card);
		list.add(card2);
		list.add(card3);
		list.add(card4);
		list.add(card5);
		return list;
	}
	
	
}