package lesson6;
import java.util.ArrayList;
/**
 * 進行役クラス
 * @author yuna
 * @date 2023/6/20
 */
public class Master {
	//プレイヤーのリスト
	private ArrayList<Player> playersList = new ArrayList<Player>();
	
	/**
	 * 上がり宣言されたらプレイヤーのリストからその人を除外する
	 * @param player
	 */
	public void declareWin(Player winner) {
		System.out.println(winner+"さんが上がりました！");
		playersList.remove(playersList.indexOf(winner));
		if(playersList.size() == 1) {
			Player loser = (Player) playersList.get(0);
			System.out.println(loser + "さんの負けです");
		}
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
			Card card = cards.pickCard();
			//カードを配る
			Player player = (Player) playersList.get(index%numberOfPlayers);
			player.receiveCard(card);
		}
	}
	/**
	 * ゲームを開始する
	 */
	public void startGame() {
		System.out.println("【ばば抜きをはじめます】");
		//プレイヤーの人数を数える
		for(int count = 0; playersList.size() > 1 ; count++) {
			int playerIndex = count % playersList.size();
			int nextPlayerIndex = (count + 1)%playersList.size();
			
			//指定するプレイヤーの取得
			Player player =  playersList.get(playerIndex) ;
			Player nextPlayer = playersList.get(nextPlayerIndex);
			
			System.out.println("\n"+player+"さんの番です");
			player.nextPlayer(nextPlayer);
		}
		System.out.println("【ばば抜きを終了しました】");
	}
	/**
	 * ゲーム参加者の登録
	 */
	public void registerPlayer(Player player) {
		playersList.add(player);
	}
}
