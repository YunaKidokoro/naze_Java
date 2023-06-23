
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
		//村田の戦略のインスタンスを生成
		Tactics murataTactics = new CyclicTactics();
		//村田に戦略クラスを渡す
		murata.setTactics(murataTactics);
		//山田の戦略のインスタンスを生成する
		Tactics yamadaTactics = new RandomTactics();
		//山田に戦略クラスを渡す
		yamada.setTactics(yamadaTactics);
		//murataとyamadaのじゃんけんを開始する
		saito.startJanken(murata,yamada);
	}
}