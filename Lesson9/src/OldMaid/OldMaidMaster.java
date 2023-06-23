package OldMaid;

import lesson8.Card;
import lesson8.Hand;
import lesson8.Master;
import lesson8.Player;

/**
 * ババ抜き用の進行役クラス
 * @author yuna
 * @date 2023/6/22
 */
public class OldMaidMaster extends Master{
	
	/**
	 * ゲームの準備をする
	 * プレイヤーに順番にカードを配り、
	 * 手札に同じで数字があればテーブルに捨てる
	 * @param cards 進行役の手札
	 */
	@Override
	public void prepareGame(Hand cards) {
		//ゲームの準備を始めることを表示する
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
			//プレイヤーはカードを受け取り、手札に同じ数があればテーブルに捨てる
			player.receiveCard(card);
		}
	}

}
