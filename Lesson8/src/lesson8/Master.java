package lesson8;

import java.util.ArrayList;

/**
 * ゲームマスタークラス　
 * @author yuna
 * @date 2023/6/21
 */
public class Master {
	//プレイヤーのリスト
		protected ArrayList<Player> playersList = new ArrayList<Player>();
		
		/**
		 * 上がり宣言されたらプレイヤーのリストからその人を除外する
		 * @param player
		 */
		public void declareWin(Player winner) {
			System.out.println(winner+"さんが上がりました！");
			//上がったプレイヤーをリストからはずす
			deregisterPlayer(winner);
		}
		
		/**
		 * ゲームの準備をする
		 * @param cards 進行役の手札
		 */
		public void prepareGame(Hand cards) {
			System.out.println("【カードを配ります】");
			//トランプをシャッフルする
			cards.shuffleCard();
			//トランプの枚数を取得する
			int numberOfCards = cards.getNumberOfCards();
			//プレイヤーの人数を取得する
			int numberOfPlayers = playersList.size();
			//手札がなくなるまでカードを配る
			for(int index = 0; index < numberOfCards; index++) {
				//カードを一枚引く
				Card card = cards.pickCard(0);
				//カードを配る
				Player player = (Player) playersList.get(index%numberOfPlayers);
				player.receiveCard(card);
			}
		}
		/**
		 * ゲームを開始する
		 */
		public void startGame() {
			System.out.println("【ゲームを開始します】");
			//プレイヤーの人数を数える
			for(int count = 0; playersList.size() > 1 ; count++) {
				int playerIndex = count % playersList.size();
				int nextPlayerIndex = (count + 1)%playersList.size();
				
				//指定するプレイヤーの取得
				Player player =  playersList.get(playerIndex) ;
				Player nextPlayer = playersList.get(nextPlayerIndex);
				
				System.out.println("\n"+player+"さんの番です");
				player.play(nextPlayer);
			}
			System.out.println("【ゲームを終了しました】");
		}
		/**
		 * ゲーム参加者の登録
		 * @param 参加者
		 * @author yuna
		 */
		public void registerPlayer(Player player) {
			playersList.add(player);
		}
		
		/**
		 * 登録済みプレイヤーを参加者リストから削除する
		 * @param winner 上がったプレイヤー
		 */
		public void deregisterPlayer(Player winner) {
			//リストから参加者を削除する
			playersList.remove(playersList.indexOf(winner));
			//残りプレイヤーが一人なったら敗者を表示する
			if(playersList.size() == 1) {
				//敗者は最後まで参加者リストにいた人
				Player loser = (Player) playersList.get(0);
				//負けたプレイヤー名を表示する
				System.out.println(loser + "さんの負けです");
			}
		}
}