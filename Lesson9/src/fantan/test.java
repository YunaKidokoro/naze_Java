package fantan;

import lesson8.Card;
import lesson8.Hand;
/**
 * @author yuna
 *
 */
public class test {

	/**
	 * 七並べのテストクラス
	 * @param ayuna
	 */
	public static void main(String[]args) {
		//進行役の生成
		FantanMaster masterPlayer = new FantanMaster();
		//テーブルの生成
		FantanTable fantanTable   = new FantanTable();
		//ルールの生成 
	    FantanRule fantanRule = new FantanRule();
		//プレイヤー生成
	    FantanPlayer murata = new FantanPlayer("村田",masterPlayer,fantanTable,fantanRule);
	    FantanPlayer yamada = new FantanPlayer("山田",masterPlayer,fantanTable,fantanRule);
	    FantanPlayer saito  = new FantanPlayer("斎藤",masterPlayer,fantanTable,fantanRule);
		//プレイヤーの登録
	    masterPlayer.registerPlayer(murata);
	    masterPlayer.registerPlayer(yamada);
	    masterPlayer.registerPlayer(saito);
		//トランプを生成する
		Hand handTrump = createtrump();
		//ゲームの準備をする
		masterPlayer.prepareGame(handTrump);
		//ゲームを開始する
		masterPlayer.startGame();
	}

private static Hand createtrump() {
	//トランプを生成する
	Hand trump = new Hand();
	//数字の1から13まで
	for(int number= 1; number<=13 ; number++) {
		//スートがクローバーのカードを生成してトランプの手札に加える
		trump.addCard(new Card(Card.SUIT_CLOVER, number));
		//スートがハートのカード
		trump.addCard(new Card(Card.SUIT_HEART, number));
		//スートがダイヤのカード
		trump.addCard(new Card(Card.SUIT_DIAMOND, number));
		//スートがスペードのカード
		trump.addCard(new Card(Card.SUIT_SPADE, number));
	}
	//トランプを返却する（今回はジョーカーを含まない）
	return trump;
}
}
