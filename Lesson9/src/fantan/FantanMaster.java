package fantan;
import lesson8.Master;
/**
 * 七並べの進行役クラス
 * @author yuna
 * @date 2023/6/22
 */
public class FantanMaster extends Master{

	//パスできる回数を表すフィールド
	final static int PASSABLE_LIMIT = 3;
	
	/**
	 * パスを宣言されたらパスした回数を表示する
	 * 4回目のパスの場合はプレイヤーを失格にする
	 * @param player パスするプレイヤー
	 * @author yuna
	 */
	public void pass(FantanPlayer player) {
		//プレイヤーがパスした回数を取得する
		int passCount = player.getPassCount();
		//パスした回数が3回までの場合
		if(passCount<=PASSABLE_LIMIT) {
			//プレイヤーのパスした回数を表示する
			System.out.println(player.toString() +"さんのパスした回数："+ passCount);
			//パスした回数をカウントする
			passCount++;
		}
		//4回目のパスをした場合
		else {
			//プレイヤーを負けにする
			System.out.println(player.toString() +"さんの負けです");
			//参加者リストから除名する
			deregisterPlayer(player);
		}
	}
}