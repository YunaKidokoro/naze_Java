
/**
 * グーしか出さない戦略クラス
 * @author yuna
 * @date 2023/6/19
 */
public class StoneOnlyTactics implements Tactics {
	
	/**
	 * 戦略をよんでじゃんけんの手を決める
	 * @return じゃんけんの手返す
	 * @author yuna
	 */
	public int readTactics() {
		//出す手を必ずグーにする
		return Player.STONE;
	}
	

}
