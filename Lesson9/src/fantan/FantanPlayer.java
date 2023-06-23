package fantan;
import lesson8.Card;
import lesson8.Player;


/**
 * 七並べのプレイヤークラス
 * @author yuna
 * @date 2023/6/22
 *
 */
public class FantanPlayer extends Player{
	

	//コンストラクタ　
	FantanPlayer(String playerName, FantanMaster masterPlayer,
			FantanTable table_, FantanRule trumpRule) {
		super(playerName,masterPlayer,table_,trumpRule);
	}
	
	//パスした回数を数える
	private int passCount = 0;
	
	/**
	 * パスした回数を数えて返却する
	 * @return パスした回数を返却する
	 */
	public int getPassCount() {
		//パスした回数をカウントする、
		passCount++;
		//回数を返却する
		return passCount;
	}

	@Override
	public void play(Player nextPlayer) {
		System.out.println(" "+ myHand);
		//テーブルをみておけるカードを探す
		Card[] candidate = trumpRule.findCandidate(myHand,table_);
		//返値がnullでない場合(おけるカード有)		
		if( candidate != null ) {
			System.out.println(playerName+":"+candidate[0] + "を置きました。\n");
			//テーブルにカードを置く
			table_.putCard(candidate );
			//手札が0枚になったら
			if(myHand.getNumberOfCards() == 0) {
				//上がり宣言をする
				masterPlayer.declareWin(nextPlayer);
			}
		}
		//そうでない場合
		else {
			//進行役にパスを宣言する
			((FantanMaster)masterPlayer).pass((FantanPlayer) nextPlayer);
			if(passCount>FantanMaster.PASSABLE_LIMIT) {
				//残りの手札の枚数を数える
				int NumberOfLeaveCard = myHand.getNumberOfCards();
				//持っていたカードをすべてテーブルに置く
				for(int index=0 ; index<NumberOfLeaveCard ; index++) {
					//手札からカードを一枚引く
					Card[] leaveCards = {myHand.pickCard(0)};
					//引いたカードを置く
					table_.putCard(leaveCards);
				}
			}	
		}
		//テーブルの状態を表示する
		System.out.println(table_);
	}
	/**
	 * 進行役から配られたカードを手札に加える
	 * そのカードが７だった場合はテーブルに並べる
	 * @param card 手札として受け取ったカード
	 */
	@Override
	public void receiveCard(Card card) {
		//配られたカードをみる
		int cardNumber = card.getCardNumber();
		//数字が７の場合
		if(cardNumber == 7) {
			System.out.println(playerName + ":" + card + "を置きました。");
			//カード型の配列を引数にとるので…
//			Card[] sevenCard = new Card[1];
			//テーブルにカードを置く
			table_.putCard(new Card[] {card}) ;
		}
		//そうでない場合は
		else {
			//カードを自分の手札に加える
			super.receiveCard(card);
		}
	}
}
