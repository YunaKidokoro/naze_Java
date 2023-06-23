/**
 * グー・チョキ・パーを順番に出す戦略クラス
 * @author yuna 
 * @date 2023/6/19
 */
public class CyclicTactics implements Tactics{
	//整数を３つに分けるための変数
	private static int classifyNumber = 0;
	/**
	 * グー・チョキ・パーを順番に出す戦略を渡す
	 * @return プレイヤーの出す手を返却する
	 * @author yuna
	 * @date 2023/6/19
	 */
	public int readTactics() {
		//プレイヤーの出す手を表す変数
		int playerHand = 0;
		//何回戦目かを表す変数
		int NumberOfGame = Judge.countGames;
		//３の倍数の試合回数めの時
		if(NumberOfGame%3 == 0) {
			//変数をインクリメント
			classifyNumber++;
		}
		//３の倍数戦めの場合
		if(NumberOfGame == 3*classifyNumber) {
			//プレイヤーの出す手をパーにする
			playerHand = Player.PAPER;
		}
		//3k+1戦目の場合
		else if(NumberOfGame == 1 + 3*classifyNumber) {
			//プレイヤーの出す手をグーにする
			playerHand = Player.STONE;
		}
		//3k+2戦目の場合
		else{
			//プレイヤーの出す手をチョキにする
			playerHand = Player.SCISSORS;
		}
		
		//プレイヤーの出す手を返す
		return playerHand;
	}
}
