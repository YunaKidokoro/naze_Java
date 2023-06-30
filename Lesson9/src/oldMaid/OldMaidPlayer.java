package oldMaid;

import lesson8.Card;
import lesson8.Hand;
import lesson8.Master;
import lesson8.Player; 
/**
 * @author staff
 *
 */
public class OldMaidPlayer extends Player{
	//コンストラクタ
	OldMaidPlayer(String playerName, Master masterPlayer,
			OldMaidTable table_, OldMaidRule trumpRule) 
	{
		super(playerName,masterPlayer,table_,trumpRule);
	}

	/**
	 * ババ抜きでプレイヤーが自分のターンに行うこと
	 * @param nextPlayer　次の順番のプレイヤー
	 */
	@Override
	public void play(Player nextPlayer) {
		//次のプレイヤーに手札を出してもらう
		Hand nextHand = ((OldMaidPlayer) nextPlayer).showHand();
		//相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard(0);
		//引いた結果を表示する
		System.out.println(this +"："+nextPlayer+"さんから"+pickedCard+"を引きました");
		//引いたカードを自分の手札に加える、同じ数字のカードは捨てる
		receiveCard(pickedCard);
		//手札の枚数を調べる
		//手札の枚数が０の場合
		if(myHand.getNumberOfCards() == 0) {
			//進行役に上がり宣言する
			masterPlayer.declareWin(this);
		}
		//そうでなければ現在の手札を確認する
		else {
			System.out.println(this+"：残りの手札は\n"+myHand+"です");
		}
	}
	
	/**
	 * カードを受け取る・または配る<br>
	 * 必要に応じてオーバーライドすること
	 * @param card 受け取ったカード
	 * @author yuna
	 */
	@Override
	public void receiveCard(Card card) {
		//カードを自分の手札に加える
		myHand.addCard(card);
		//今加えたカードと同じ数字のカードが無いか調べる
		Card[] sameCards = trumpRule.findCandidate(myHand,table_);
		//同じ数字のカードあった場合
		if(sameCards != null) {
			//誰がどのカードを捨てたかを表示する
			System.out.print(this+"：");
			//カードをテーブルに捨てる
			table_.putCard(sameCards);
		}
	}
	/**
	 * @return  自分の手札を見せる
	 */
	public Hand showHand() {
		//もし手札が残り一枚の場合
		if(myHand.getNumberOfCards() == 1) {
			//進行役に上がり宣言する
			masterPlayer.declareWin(this);
		}
		//見せる前にシャッフルする
		myHand.shuffleCard();
		//手札を見せる
		return myHand;
	}
}