package lesson8;

/**
 * トランプゲームのテーブルインタフェース
 * いわゆる「場」
 * @author yuna
 * @date 2023/6/21
 */
public interface Table {
	/**
	 * カードを置く
	 * テーブルにおかれたカードの扱いについてはサブクラスで実装
	 * @param card カード
	 */
	public void putCard(Card[] card) ;
	
	
	/**
	 * カードを見る
	 * @return テーブルにおかれたカードを表す配列
	 * 多重配列なのはカードがどのように並んでいるかを表現するため
	 */
	public Card[][] getCards();
}

