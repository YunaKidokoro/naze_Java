package lesson6;

/**
 * ばば抜きのプレイヤークラス
 * @author yuna
 * @date 2023/6/20
 * 
 */
public class Player {
	
	//名前を表すフィールド
	public String playerName;
	//進行役
	private Master masterPlayer;
	//テーブル
	private Table table_;
	//自分の手札のインスタンス
	private Hand myHand = new Hand();
	
	//引数を受け取らないコンストラクタ
	Player(){}
	//引数に名前を受け取るコンストラクタ
	Player(String playerName){
		this.playerName = playerName;
	}
	//引数に名前・進行役・テーブルを受け取るコンストラクタ
	Player(String playerName, Master masterPlayer, Table table_){
		this(playerName);
		this.masterPlayer = masterPlayer;
		this.table_ = table_;
	}
	
	/**
	 * 順番を指名する
	 * @param nextPlayer
	 */
	public void nextPlayer(Player nextPlayer) {
		//次のプレイヤーに手札を出してもらう
		Hand nextHand = nextPlayer.showHand();
		//相手の手札からカードを一枚引く
		Card pickedCard = nextHand.pickCard();
		//引いた結果を表示する
		System.out.println(this +":"+nextPlayer+"さんから"+pickedCard+"を引きました");
		//引いたカードを自分の手札に加える、同じ数字のカードは捨てる
		dealCard(pickedCard);
		//手札の枚数を調べる
		//手札の枚数が０の場合
		if(myHand.getNumberOfCards() == 0) {
			//進行役に上がり宣言する
			masterPlayer.declareWin(this);
		}
		//そうでなければ現在の手札を確認する
		else {
			System.out.println(this+"：残りの手札は"+myHand+"です");
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
	/**
	 * カードを受け取る
	 * @param card
	 */
	public void receiveCard(Card card) {
		//引いたカードを自分の手札に加えて同じ数字のカードがあれば捨てる
		dealCard(card);
	}
	/**
	 * @param card
	 */
	public void dealCard(Card card) {
		//カードを自分の手札に加える
		myHand.addCard(card);
		//今加えたカードと同じ数字のカードが無いか調べる
		Card[] sameCards = myHand.findSameNumberCards();
		//同じ数字のカードあった場合
		if(sameCards != null) {
			//カードをテーブルに捨てる
			System.out.println(this+":");
			table_.disposeCard(sameCards);
		}
	}
	/**
	 * プレイヤーの名前を返す
	 */
	public String toString() {
		return playerName;
	}
}
 