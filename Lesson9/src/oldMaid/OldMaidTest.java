package oldMaid;

import lesson8.Card;
import lesson8.Hand;
import lesson8.Joker;
import lesson8.Master;

public class OldMaidTest {
	/**
	 * @param args
	 */
	public static void main(String[]args) {
		//進行役を生成
		Master masterPlayer  = new Master();
		//テーブルを生成
		OldMaidTable  field  = new OldMaidTable();
		//ババ抜きのルールを生成
		OldMaidRule oldMaidRule = new OldMaidRule();
		
		//プレイヤーの生成
	    OldMaidPlayer murata = new OldMaidPlayer("村田",masterPlayer,field,oldMaidRule);
	    OldMaidPlayer yamada = new OldMaidPlayer("山田",masterPlayer,field,oldMaidRule);
	    OldMaidPlayer saito  = new OldMaidPlayer("斎藤",masterPlayer,field,oldMaidRule);
		
	    //プレイヤーの登録
		masterPlayer.registerPlayer(murata);
		masterPlayer.registerPlayer(yamada);
		masterPlayer.registerPlayer(saito);
		
		//トランプを作る
		Hand trump = createTrump();
		//ゲームの準備をする
		masterPlayer.prepareGame(trump);
		//ゲームを開始する
		masterPlayer.startGame();
	}
	
	/**
	 * トランプを作る(カード52枚とジョーカー１枚)
	 * @return トランプのカードを返却する
	 */
	private static Hand createTrump() {
		//手札を生成する
		Hand trump = new Hand();
		//数字が１から１３まで順にカードを生成して手札に加えていく
		for(int number= 1; number<=13 ; number++) {
			//スートがクラブのカード
			trump.addCard(new Card(Card.SUIT_CLOVER, number));
			//スートがハートのカード
			trump.addCard(new Card(Card.SUIT_HEART, number));
			//スートがダイヤのカード
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			//スートがスペードのカード
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		//ジョーカーを生成して手札に加える
		trump.addCard(new Joker());
		//トランプを返す
		return trump;
	}
}

