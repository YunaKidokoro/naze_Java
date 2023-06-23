/**
 * じゃんけん戦略インタフェース
 * @author yuna
 * @date 2023/6/19
 *
 */
public interface Tactics {
	/**
	 * 戦略を読んでじゃんけんの出す手を返却する
	 * Playerクラスで定義されたグー・チョキ・パーと対応した
	 * 値を返却する
	 * @return じゃんけんの出す手を返却する
	 * @author yuna
	 * @date 2023/6/19
	 */
	public int readTactics();
}
