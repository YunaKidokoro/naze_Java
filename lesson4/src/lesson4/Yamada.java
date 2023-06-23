package lesson4;

/**
 * じゃんけんでプレイヤーのする動作
 * @author yuna
 *
 */

public class Yamada extends Player{
	//コンストラクタ
	//引数なしのコンストラクタも用意しておく
	Yamada(){}
	/**
	 * プレイヤーの名前を引数にとるコンストラクタ
	 * @author yuna
	 * @param name 
	 */
	Yamada(String name){
		//スーパーコンストラクタを呼び出す
		super(name);
	}

	//じゃんけんの手に必ずパーを出す
	/**
	 * @author yuna
	 * @param なし
	 * @return 必ずパーを返す
	 */
	@Override public int showHand() {
		//出す手を表す変数にパーの場合の値を代入する
		int playeraHand = PAPER;
		//プレイヤーの出す手（パー）を返却
		return playeraHand;
	}
}

