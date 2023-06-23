package lesson6;

/**
 * @author staff
 *
 */
public class OldMaid {
	/**
	 * @param args
	 */
	public static void main(String[]args) {
		Master master = new Master();
		Table  field  = new Table();
		
		Player mafutu = new Player("murata",master, field);
		Player murasame = new Player("yamada",master, field);
		Player kanou  = new Player("saito",master, field);
		
		
		master.registerPlayer(mafutu);
		master.registerPlayer(murasame);
		master.registerPlayer(kanou);
		
		Hand trump = createTrump();
		master.prepareGame(trump);
		master.startGame();

	}
	
	private static Hand createTrump() {
		Hand trump = new Hand();
		
		for(int number= 1; number<=13 ; number++) {
			trump.addCard(new Card(Card.SUIT_CLOVER, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		trump.addCard(new Card(0,Card.CARD_JOKER));
		
		return trump;
	}
}
