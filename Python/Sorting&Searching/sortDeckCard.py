import unittest

class Card:
	suit = None
	rank = None

	def __init__(self, suit, rank):
		self.suit = suit
		self.rank = rank


class DeckSort():

	def sort_deck(self, cards):

		for i range(len(cards)):
			card = cards[i]
			index = card.suit*13 + card.rank




class TestDeckSort(unittest.TestCase):
	def setUp(self):
		pass

	def test_sort_deck(self):
		pass






"""

Problems

Sort a deck of card

Jaba Implematation
public class SortDeckOfCard {
        static class Card {
                int suite;
                int rank;

                public Card(int suite, int rank) {.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                        this.suit = suit;
                        this.rank = rank;
                }
        } 

        public static void sortDeckOfCard(Card[] cards) {
                if (cards == null || cards.length == 0) {
                        return;
                }
                for (int i = 0; i < cards.length;) {
                        int index = cards[i].suite * 13 + cards[i].rank;
                        if (index >= 0 && index < 52
                                        && (cards[index].suite * 13 + cards[index].rank != index)) {
                                Card tmp = cards[index];
                                cards[index] = cards[i];
                                cards[i] = tmp;
                        } else {
                                i++;
                        }
                }
        }

        public static void main(String[] args) {
                Card[] cards = new Card[52];
                for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 13; j++) {
                                cards[51 - i * 13 - j] = new Card(i, j);
                        }
                }
                for (int i = 0; i < 52; i++) {
                        System.out.print((cards[i].suite * 13 + cards[i].rank) + " ");
                }
                System.out.println();
                sortDeckOfCard(cards);
                for (int i = 0; i < 52; i++) {
                        System.out.print((cards[i].suite * 13 + cards[i].rank) + " ");
                }
        }
}

"""