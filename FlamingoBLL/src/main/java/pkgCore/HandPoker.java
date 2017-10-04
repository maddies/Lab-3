package pkgCore;

import java.util.ArrayList;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		if (isRoyalFlush()) {

		} else if (isStraightFlush()) {

		} else if (isFourOfAKind()) {

		} else if (isFullHouse()) {

		} else if (isFlush()) {

		} else if (isStraight()) {

		} else if (isThreeOfAKind()) {

		} else if (isTwoPair()) {

		} else if (isPair()) {

		} else  {	
		}
		return null;
	}

	public boolean isRoyalFlush() {
		boolean bisRoyalFlush = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (isStraightFlush() && super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank() == eRank.QUEEN) {
			bisRoyalFlush = true;
			HS.seteHandStrength(eHandStrength.RoyalFlush);
		}
		return bisRoyalFlush;

	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (isStraight() && isFlush()) {
			bisStraightFlush = true;
		}

		HS.seteHandStrength(eHandStrength.StraightFlush);
		return bisStraightFlush;
	}

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {

			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FourOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);
			bisFourOfAKind = true;
		}

		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank() && super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FullHouse);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			bisFullHouse = true;
		}
			
		else if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank() && super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.FullHouse);
			HS.setHiCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			bisFullHouse = true;
		}
		return bisFullHouse;
	}

	public boolean isFlush() {
		HandScorePoker HS = (HandScorePoker) super.getHS();
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt)
			bisFlush = true;
		else
			bisFlush = false;

		if (bisFlush)
			HS.seteHandStrength(eHandStrength.Flush);

		return bisFlush;

	}

	public boolean isStraight() {
		boolean bisStraight = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()
				.compareTo(super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()) == 1
				|| super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank()
						.compareTo(super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()) == -12)
			return false;

		if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()
				.compareTo(super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()) == 1
				|| super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank()
						.compareTo(super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()) == -12)
			return false;

		if (super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()
				.compareTo(super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()) == 1
				|| super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank()
						.compareTo(super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()) == -12)
			return false;

		if (super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()
				.compareTo(super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) != 1
				|| super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank()
						.compareTo(super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank()) != -12)
			return false;

		if (bisStraight)
			HS.seteHandStrength(eHandStrength.Straight);

		return bisStraight;
	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisThreeOfAKind = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisThreeOfAKind = true;
		} else if (super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.ThreeOfAKind);
			HS.setHiCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setKickers(kickers);
			bisThreeOfAKind = true;
		}
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank() == super.getCards()
						.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisTwoPair = true;
		}

		else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank() == super.getCards()
						.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setKickers(kickers);
			bisTwoPair = true;
		}

		else if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank()
				&& super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank() == super.getCards()
						.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.TwoPair);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setKickers(kickers);
			bisTwoPair = true;
		}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.SECOND.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisPair = true;

		} else if (super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.THIRD.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisPair = true;
		} else if (super.getCards().get(eCardNo.THIRD.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FOURTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
			HS.setKickers(kickers);
			bisPair = true;
		} else if (super.getCards().get(eCardNo.FOURTH.getiCardNo()).geteRank() == super.getCards()
				.get(eCardNo.FIFTH.getiCardNo()).geteRank()) {
			HS.seteHandStrength(eHandStrength.Pair);
			HS.setHiCard(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
			HS.setLoCard(null);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.SECOND.getiCardNo()));
			kickers.add(super.getCards().get(eCardNo.THIRD.getiCardNo()));
			HS.setKickers(kickers);
			bisPair = true;
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		HandScorePoker HS = (HandScorePoker) super.getHS();

		HS.seteHandStrength(eHandStrength.HighCard);
		HS.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));

		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(super.getCards().get(eCardNo.SECOND.getiCardNo()));
		kickers.add(super.getCards().get(eCardNo.THIRD.getiCardNo()));
		kickers.add(super.getCards().get(eCardNo.FOURTH.getiCardNo()));
		kickers.add(super.getCards().get(eCardNo.FIFTH.getiCardNo()));
		bisHighCard = true;
		// double check later
		return bisHighCard;
	}

}
