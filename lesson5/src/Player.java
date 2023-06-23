/**
 * じゃんけんでプレイヤーのする動作
 * @author yuna
 *
 */
public class Player{
	//じゃんけんの手を表す定数
	public static final int STONE = 0; //グー
	public static final int SCISSORS = 1; //チョキ
	public static final int PAPER = 2; //パー
	
	//-----------------
	//プレイヤークラスの属性
	//-----------------	
	
	//フィールド
	//プレイヤーの名前
	private String name_;
	//プレイヤーの勝った回数
	private int winCount_ = 0;
	
	//与えられえた戦略
	private Tactics tactics_;
	
	//コンストラクタ
	//引数なしのコンストラクタも用意しておく
	Player(){}
	/**
	 * プレイヤーの名前を引数にとるコンストラクタ
	 * @author yuna
	 * @param name 
	 */
	Player(String name){
		//名前を表すフィールドを初期化
		this.name_ = name;
	}
	/**
	 * プレイヤーの名前と勝利回数を引数にとるコンストラクタ
	 * @param name_
	 * @param winCount_
	 */
	Player(String name_, int winCount_){
		//名前を表すフィールドを初期化する
		this(name_);
		//勝利回数を表すフィールドを初期化
		this.winCount_ = winCount_;
	}
	
	/**
	 * 戦略を設定する
	 * @param tactics_
	 * @author yuna
	 * @date 2023/6/19
	 */
	public void setTactics(Tactics tactics_) {
		//戦略を引数の設定にする
		this.tactics_ = tactics_;
	}
	
	//-----------------
	//プレイヤークラスの操作
	//-----------------
	
	/**
	 * @return　プレイヤーの出す手を返す
	 */
	public int readTactics() {
		//プレイヤーの出す手を戦略を読んで決める
		int playerHand = tactics_.readTactics();
		//プレイヤーの出す手を返す
		return playerHand;
	}
	
	
	//playerクラスの動作
	//じゃんけんの手を出す
	/**
	 * @author yuna
	 * @param なし
	 * @return じゃんけんの手を値にして返す<br>
	 * グー：0 、チョキー:1、パー:2
	 */
	public int showHand() {
//		//ランダムクラスのインスタンスを生成する
//		Random RandomNumber = new Random();
//		//0から３の乱数を生成してプレイヤーの手を決める
//		int playerHand = RandomNumber.nextInt(3);
		
		//プレイヤーの出す手を戦略をもとに決める
		int playerHand = readTactics();
		//プレイヤーの出す手を返却
		return playerHand;
	}
	
	/**
	 * 審判から勝敗を聞いて勝っていれば勝利回数を数える
	 * @author yuna
	 * @param result true:勝ち、false:負け
	 * @return 無し
	 */
	public void notifyResult(boolean result) {
		//勝った場合
		if(result = true) {
			//勝利回数カウントする
			winCount_ +=1;
		}
	}
	
	/**
	 * 勝利回数を答える
	 * @author yuna
	 * @return 勝った回数を返却する
	 */
	public int getWinCount() {
		//勝利回数を返却
		return 	winCount_;
	}
	
	/*一応…
	 * 関数名:getName
	 * 概要:名前を調べる
	 * 引数:なし
	 * 戻り値:string型・name_・その人の名前
	 * */
	String getName() {
		//その人の名前を返す
		return name_;
	}
}
