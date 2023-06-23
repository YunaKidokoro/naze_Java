package lesson8;

/**
 * プレイヤークラス
 * @author staff
 * @date 2023/6/21
 */
public abstract class Player {
	

	//名前を表すフィールド
	protected String playerName;
	//進行役
	protected Master masterPlayer;
	//テーブル
	protected Table table_;
	//自分の手札のインスタンス
	protected Hand myHand = new Hand();
	//
	protected Rule trumpRule;
	
	//引数を受け取らないコンストラクタ
	protected Player(){}
	//引数に名前を受け取るコンストラクタ
	Player(String playerName){
		this.playerName = playerName;
	}
	//引数に名前・進行役・テーブル・ルールを受け取るコンストラクタ
	protected Player(String playerName, Master masterPlayer, Table table_, Rule trumpRule){
		this(playerName);
		this.masterPlayer = masterPlayer;
		this.table_ = table_;
		this.trumpRule =trumpRule;
	}
	
	/**
	 * 順番を指名する
	 * @param nextPlayer 次のプレイヤー
	 * @author yuna
	 */
	public abstract void play(Player nextPlayer);

	/**
	 * カードを受け取る・または配る<br>
	 * 必要に応じてオーバーライドすること
	 * @param card 受け取ったカード
	 * @author yuna
	 */
	public void receiveCard(Card card) {
		//カードを自分の手札に加える
		myHand.addCard(card);
	}
	/**
	 * プレイヤーの名前を返す
	 */
	public String toString() {
		return playerName;
	}
}
