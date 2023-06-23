package lesson3_janken;

/**
 * オブジェクト指向によるじゃんけんプログラム
 * @author yuna
 * @createDate 2023/6/16
 */
public class ObjectJanken {
	
	/**
	 * @author yuna
	 * @createDate 2023/6/16
	 * @param args
	 */
	public static void main(String[]args) {
		//審判クラスのインスタンスを生成
		Judge saito = new Judge();
		//プレイヤー１の名前
		String player1Name = "murata";
		//プレイヤー２の名前
		String player2Name = "yamada";
		//プレイヤー１のインスタンスを生成
		Player murata = new Player(player1Name);
		//プレイヤー２のインスタンスを生成
		Player yamada = new Player(player2Name);
		//murataとyamadaのじゃんけんを開始する
		saito.startJanken(murata,yamada);
	}
}
