package lesson4;

/**
 * じゃんけんの判定を行うクラス
 * @author yuna
 * @createDate 2023/6/16
 */
public class Judge {
	
	//じゃんけんの手を表す定数
	public static final int HAND_STONE = 0; //グー
	public static final int HAND_SCISSORS = 1; //チョキ
	public static final int HAND_PAPER = 2; //パー
	
	/**
	 * じゃんけんを開始する
	 * @param player1　判定対象プレイヤー１
	 * @param player2　判定対象プレイヤー２
	 * @return なし
	 * @author yuna
	 */
	public void startJanken(Player player1, Player player2) {
		//じゃんけんの開始を合図する
		System.out.println("【じゃんけん開始】\n");
		//じゃんけんをする回数を表す変数
		int numberOfGames = 3;
		//じゃんけんする回数ループする
		for(int count=0; count<numberOfGames; count++) {
			//何回戦目かを表示する
			System.out.println("\n【"+(count+1)+"回戦目】");
			//2人のプレイヤーの内どちらが勝者かを判定する
			Player winner = judgeJanken(player1,player2);
			//引き分けでない場合
			if(winner != null) {
				//誰が勝ったかを表示する
				System.out.println("\n"+winner.getName() + "が勝ちました！\n");
				//勝ったプレイヤーに結果を伝える
				winner.notifyResult(true);
			}
			//引き分けの場合
			else {
				//引き分けだったことを表示する
				System.out.println("\n引き分けです！\n");
			}
		}
		//じゃんけんの終了を合図する
		System.out.println("【じゃんけん終了】");
		//最終的な勝者の判定をする
		Player finalWinner = judgeFinalWinner(player1,player2);
		//何対何で勝敗がどうなったかを表示する
		System.out.print(player1.getWinCount() +"対"+ player2.getWinCount() + "で");
		//引き分けでない場合
		if(finalWinner != null) {
			//誰が勝ったかを表示する
			System.out.println(finalWinner.getName()+"の勝ちです！\n");
		}
		//引き分けの場合
		else {
			//引き分けたことを表示する
			System.out.println("引き分けです\n");
		}
	}
	
	private Player judgeJanken(Player player1, Player player2) {
		//勝者を表す変数、NULLは引き分けを表す
		Player winner = null;
		//プレイヤー１の出す手を取り出す
		int player1Hand = player1.showHand();
		//プレイヤー２の出す手を取り出す
		int player2Hand = player2.showHand();
		//プレイヤー１の出す手を表示する
		printHand(player1Hand);
		//vsを表示して勝負を表す
		System.out.print("vs.");
		//プレイヤー１の出す手を表示する
		printHand(player2Hand);
		//改行
		System.out.println();
		//プレイヤー１が勝つ場合
		if(
			//プレイヤー１がグーでプレイヤー２がチョキの場合
			(player1Hand==HAND_STONE && player2Hand==HAND_SCISSORS)
			//または、プレイヤー１がチョキでプレイヤー2がパーの場合
			||  (player1Hand==HAND_SCISSORS && player2Hand==HAND_PAPER)
			//または、プレイヤー１がパーでプレイヤー２がグーの場合
			||  (player1Hand==HAND_PAPER && player2Hand==HAND_STONE)
		) {
			//プレイヤー１を勝者にする
			winner = player1;
		}
		//プレイヤー2が勝つ場合
		else if(
			//プレイヤー２がグーでプレイヤー１がチョキの場合
			(player2Hand==HAND_STONE && player1Hand==HAND_SCISSORS)
			//または、プレイヤー２がチョキでプレイヤー１がパーの場合
			||  (player2Hand==HAND_SCISSORS && player1Hand==HAND_PAPER)
			//または、プレイヤー２がパーでプレイヤー１がグーの場合
			||  (player2Hand==HAND_PAPER && player1Hand==HAND_STONE)
		) {
			//プレイヤー２を勝者にする
			winner = player2;
		}
		//勝った人を返す、nullは引き分け
		return winner;
	}
	
	/**
	 * 最終的な勝者を判定する
	 * @param player1
	 * @param player2
	 * @return 最終的な勝者が誰か返す
	 */
	private Player judgeFinalWinner(Player player1, Player player2){
		//最終的な勝者を表す変数、nullは引き分けを表す
		Player finalWinner = null;
		//プレイヤー１の勝利数を取り出す
		int player1Count = player1.getWinCount();
		//プレイヤー２の勝利数を取り出す
		int player2Count = player2.getWinCount();
		
		//プレイヤー１の方が多く勝った場合
		if(player1Count > player2Count) {
			//最終的な勝者をプレイヤー１とする
			finalWinner = player1;
		}
		//プレイヤー２の方が多く勝った場合
		else if(player1Count < player2Count) {
			//最終的な勝者をプレイヤー２とする
			finalWinner = player2;
		}
		//最終的な勝者が誰か返却する
		return finalWinner;
	}
	
	
	/**
	 * プレイヤーが誰かを引数に取ってプレイヤーの出す手を表示する
	 * @param player
	 */
	static void printHand(Player player) {
		//引数にとったプレイヤーの出す手を取り出す
		int PlayerHand = player.showHand();
		//出す手がグー(0)の時
		if(PlayerHand==HAND_STONE) {
			//グーを表示する
			System.out.print(player.getName() + ":グー");
		}
		//出す手がチョキ(1)の時
		if(PlayerHand==HAND_SCISSORS) {
			//チョキを表示する
			System.out.print(player.getName() + ":チョキ");
		}
		//出す手がチョキ(2)の時
		if(PlayerHand==HAND_PAPER) {
			//チョキを表示する
			System.out.print(player.getName() + ":パー");
		}
	}
	
	/**
	 * 引数に出す手を表す値をとってプレイヤーの出す手を表示する
	 * @param hand 
	 */
	static void printHand(int hand) {
		//出す手がグー(0)の時
		if(hand==HAND_STONE) {
			//グーを表示する
			System.out.print("グー");
		}
		//出す手がチョキ(1)の時
		if(hand==HAND_SCISSORS) {
			//チョキを表示する
			System.out.print( "チョキ");
		}
		//出す手がチョキ(2)の時
		if(hand==HAND_PAPER) {
			//チョキを表示する
			System.out.print("パー");
		}
	}

}//一番外側のかっこ