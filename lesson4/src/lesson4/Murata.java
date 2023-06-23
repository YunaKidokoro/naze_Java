package lesson4;

/**
 * じゃんけんでプレイヤーのする動作
 * @author yuna
 *
 */

public class Murata extends Player{
	//コンストラクタ
	//引数なしのコンストラクタも用意しておく
	Murata(){}
	/**
	 * プレイヤーの名前を引数にとるコンストラクタ
	 * @author yuna
	 * @param name 
	 */
	Murata(String name){
		//スーパーコンストラクタを呼び出す
		super(name);
	}

	//じゃんけんの手に必ずグーを出す
	/**
	 * @author yuna
	 * @param なし
	 * @return 必ずグーを返す
	 */
	@Override public int showHand() {
		//出す手を表す変数にグーの場合の値を代入する
		int playeraHand = STONE;
		//プレイヤーの出す手（グー）を返却
		return playeraHand;
	}
}

