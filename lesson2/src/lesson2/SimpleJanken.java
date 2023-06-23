package lesson2;
//ランダムクラスをインポートする
import java.util.Random;
/**
 * Work2-2
 * @author yuna
 * @date 2023/6/16
 */
public class SimpleJanken {
	//じゃんけんの出す手がグーを表す定数
	public static final int HAND_STONE = 0;
	//じゃんけんの出す手がチョキを表す定数
	public static final int HAND_SCISSORS = 1;
	//じゃんけんの出す手がパーを表す定数
	public static final int HAND_PAPER = 2;
	
	/**
	 * オブジェクト指向を使わないでじゃんけんプログラムを作成する
	 * @param args
	 * @author yuna
	 * @date 2023/6/16
	 */
	public static void main (String[]args) {
		//じゃんけんのプログラム開始したことを表示する
		System.out.println("じゃんけん開始");
		//ゲーム回数を表す変数を宣言
		int NumberOfGame = 3;
		//プレイヤー１の出す手を表す変数を宣言
		double player1Hand = 0;
		//プレイヤー２の出す手を表す変数を宣言
		double player2Hand = 0;
		//プレイヤー１の勝利数を表す変数を宣言
		int player1WinCount = 0;
		//プレイヤー2の勝利数を表す変数を宣言
		int player2WinCount = 0;
				
		//ループの開始
		for(int i=1; i <= NumberOfGame; i++) {
			System.out.println("\n【"+i+"回戦目】");

			//ランダムクラスのインスタンスを生成する
			Random randomNumber = new Random();
			/*
			 * プレイヤー１が何を出すか決める
			 * */
			//0から2の乱数を生成してプレイヤー１の出す手を決める
			player1Hand = randomNumber.nextInt(3);
			//プレイヤー１の出す手がグー(0)の場合
			if(player1Hand==HAND_STONE) {
				//プレイヤー１の手を表示する
				System.out.print("グー");
			}
			//プレイヤー１の出す手がチョキ(1)の場合
			else if(player1Hand==HAND_SCISSORS) {
				//プレイヤー１の手を表示する
				System.out.print("チョキ");
			}
			//プレイヤー１の出す手がパー(2)の場合
			if(player1Hand==HAND_PAPER) {
				//プレイヤー１の手を表示する
				System.out.print("パー");
			}
			//対戦してることを表したいので表示する
			System.out.print("vs.");
			
			/*
			 * プレイヤー2が何を出すか決める
			 * */
			//0から2の乱数を生成してプレイヤー2の出す手を決める
			player1Hand = randomNumber.nextInt(3);
			//プレイヤー2の出す手がグー(0)の場合
			if(player1Hand==HAND_STONE) {
				//プレイヤー2の手を表示する
				System.out.print("グー");
			}
			//プレイヤー2の出す手がチョキ(1)の場合
			else if(player1Hand==HAND_SCISSORS) {
				//プレイヤー2の手を表示する
				System.out.print("チョキ");
			}
			//プレイヤー2の出す手がパー(2)の場合
			else{
				//プレイヤー2の手を表示する
				System.out.print("パー");
			}
			/*
			 * どっちのプレイヤーが勝ったかを判定する
			 * */
			//プレイヤー１が勝った場合
			if(
					//プレイヤー１がグーでプレイヤー２がチョキの場合
					(player1Hand==HAND_STONE && player2Hand==HAND_SCISSORS)
					//または、プレイヤー１がチョキでプレイヤー2がパーの場合
					||  (player1Hand==HAND_SCISSORS && player2Hand==HAND_PAPER)
					//または、プレイヤー１がパーでプレイヤー２がグーの場合
					||  (player1Hand==HAND_PAPER && player2Hand==HAND_STONE)
				) {
				//プレイヤー１が勝ったことを表示する
				System.out.println("\nプレイヤー１の勝ちです！");
				//プレイヤー１の勝利数をカウントする
				player1WinCount++;
			}
			//プレイヤー２が勝った場合
			else if(
					//プレイヤー２がグーでプレイヤー１がチョキの場合
					(player2Hand==HAND_STONE && player1Hand==HAND_SCISSORS)
					//または、プレイヤー２がチョキでプレイヤー１がパーの場合
					||  (player2Hand==HAND_SCISSORS && player1Hand==HAND_PAPER)
					//または、プレイヤー２がパーでプレイヤー１がグーの場合
					||  (player2Hand==HAND_PAPER && player1Hand==HAND_STONE)
				) {
					//プレイヤー２が勝ったことを表示する
					System.out.println("\nプレイヤー2の勝ちです！");
					//プレイヤー２の勝利数をカウントする
					player2WinCount++;
				}
			//引き分けの場合
			else {
				//引き分けだったことを表示する
				System.out.println("\n引き分けです");
			}
		}
		/*
		 * 最終的な勝者を表示する
		 * */
		//じゃんけん終了の合図
		System.out.println("\n【じゃんけん終了】");
		//勝利回数が多いプレイヤーを判定して表示する
		//プレイヤー２の方が多く勝っていた場合
		if(player1WinCount < player2WinCount) {
			//最終的な勝者がプレイヤー２であることを表示
			System.out.println(player1WinCount +"対"+ player2WinCount + "でプレイヤー2の勝ちです！");
		}
		//プレイヤー１の方が多く勝っていた場合
		else if(player1WinCount > player2WinCount) {
			//最終的な勝者がプレイヤー１であることを表示
			System.out.println(player1WinCount +"対"+ player2WinCount + "でプレイヤー１の勝ちです！");
		}
		//引き分けの場合
		else {
			//引き分けだったことを表示する
			System.out.println(player1WinCount +"対"+ player2WinCount + "で引き分けです");
		}
	}
}
