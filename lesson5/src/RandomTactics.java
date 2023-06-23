
/**
 * ランダムに手を決める戦略クラス
 * @author yuna
 * @date 2023/6/19
 */
public class RandomTactics implements Tactics {
	
	//じゃんけんの手を表す定数
	public static final int STONE = 0; //グー
	public static final int SCISSORS = 1; //チョキ
	public static final int PAPER = 2; //パー
	
	/**
	 * 戦略を読んでじゃんけんの手を得る
	 * @return じゃんけんの手
	 * @author yuna
	 * @date 2023/6/19
	 */
	public int readTactics() {
		//プレイヤーの出す手を表す変数をグーの値で初期化しておく
		int playerHand = STONE;
		//0から3の値の乱数を生成する
		double randomNum = Math.random()*3;
		//乱数が1未満の時
		if(randomNum < 1) {
			//出す手をグーにする
			playerHand = STONE;
		}
		//乱数が１以上２未満の時
		else if(randomNum < 2) {
			//出す手をチョキにする
			playerHand = SCISSORS;
		}
		//乱数が２以上の時
		else {
			//プレイヤーの出す手を返す
			playerHand = PAPER;
		}
		
		//プレイヤーの出す手を返す
		return playerHand;
	}
}
