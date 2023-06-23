package lesson8;

/**
 * トランプルールのインタフェース
 * @author yuna
 * @date 2023/6/21
 */
public interface Rule {
	/**
	 * テーブルにおけるカードを探す<br>
	 * 現在の手札とテーブルから、出しうるカードの組み合わせを見つける
	 * @param hand		手札
	 * @param table		テーブル
	 * @return　見つかったカードの組み合わせ、見つからない時はnullを返す
	 */
	public Card[] findCandidate(Hand hand, Table table);
	
	
}
