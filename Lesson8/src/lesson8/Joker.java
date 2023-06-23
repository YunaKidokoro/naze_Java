package lesson8;

/**
 * ジョーカーを表すクラス<br>
 * Cardクラスを継承している
 * @author yuna
 * @date 2023/6/21
 */
public class Joker extends Card{
	/**
	 * 引数を受け取らないコンストラクタ
	 * デフォルトではgetSuitに０をgetNumberに０を返す
	 */
	public Joker() {
		super(0,0);
	}
	
	/**
	 * ジョーカーを好きな数字のカードに変える
	 * @param number 変えたい数字
	 * @author yuna
	 */
	public void setNumber(int number) {
		//ジョーカーの数字に引数の数字を設定する
		this.cardNumber = number;
	}
	
	/**
	 * ジョーカーを好きなスートのカードに変える
	 * @param suit 変えたいスート
	 * @author yuna
	 */
	public void setSuit(int suit) {
		this.cardSuit = suit;
	}
	
	/**
	 * カードを文字列で表現する<br>
	 * toStringのオーバーライド
	 * @return カードの文字列表現
	 * @author yuna
	 */
	public String toString() {
		return  "JK";
	}

}
