package lesson8;

import java.util.ArrayList;
import java.util.Random;

/**
 * トランプの手札クラス
 * @author yuna
 * @date 2023/6/21
 */
public class Hand {
	
	/*　
	 * クラスの属性　
	 * */
	//手札を表すリスト
	protected ArrayList<Card> handList = new ArrayList<Card>();
	

	/**
	 * 手札にカードを加える
	 * @param pulsCard　手札に加えるカード
	 * @author yuna
	 */
	public void addCard(Card pulsCard) {
		//手札のリストの後ろに新しいカードを加える
		handList.add(pulsCard);
	}
	
	/**
	 * カードを見る
	 * @param position <br>
	 * 			0からgetNumberOfCards()の範囲で指定
	 * @return 指定された位置のカード<br>
	 * 			指定した位置が手札の範囲外であればnullを返す
	 * @author yuna
	 */
	public Card lookCard(int position) {
		//見たいカードを表す変数
		Card lookingCard = null;
		//指定位置が手札の範囲の場合
		if((0 <= position) && (position<handList.size())) {
			//その位置のカードを表す値を代入する
			lookingCard = (Card)handList.get(position);
		}
		//指定位置のカードを返す
		return lookingCard;
	}
	
	/**
	 * カードを任意の位置から一枚引く
	 * 引いたカードは手札から削除される
	 * @param potision カードの位置
	 * @return 引いたカードを返す
	 * @author yuna
	 */
	public Card pickCard(int position) {
		//指定位置のカードを表す変数
		Card pickedCard = null;
		//指定位置が手札の範囲の場合
		if((0 <= position) && (position<handList.size())) {
			//手札のリストから一枚取り除く
			pickedCard = (Card)handList.remove(position);
		}
		//引いたカードを返す
		return pickedCard;
	}
	
	/**
	 * 手札の枚数を数える
	 * @return カードの枚数(リストの要素数)を返す
	 */
	public int getNumberOfCards() {
		//リストの要素数を手札の枚数として返却する
		return handList.size();
	}
	
	/**
	 * 手札をシャッフルする
	 */
	public void shuffleCard() {
		//手札の枚数を数える
		int numberOfHand = handList.size();
		//カードを抜き出す位置を表す変数
		int cardPosition=0;
		//カードをランダムな位置で抜き取って手札の最後に加える
		for(int count=0 ; count < numberOfHand*2 ; count++) {
			//ランダムクラスのインスタンスを生成する
			Random random = new Random();
			//手札の枚数に対応した数の乱数を生成してカードの位置に代入する
			cardPosition = random.nextInt(numberOfHand);
			//ランダムな位置からカードを抜き出す
			Card pickedCard = (Card) handList.remove(cardPosition);
			//抜き取ったカードを手札の最後に戻す
			handList.add(pickedCard);
		}
	}

	/**
	 * 手札の中身を表す文字列表現を返却する
	 * @return　文字列表現を返す
	 * @author yuna
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		//手札の枚数を取得する
		int handSize = handList.size();
		//手札の枚数が１枚以上の場合
		if(handSize > 0) {
			//手札リストの先頭から末尾までループ
			for (int index=0; index < handSize ; index++) {
				//カードのスートと数字を調べる
				Card card = (Card) handList.get(index);
				//カードのスートと数字を文字列に加える
				string.append(card);
				//適度なスペースも加えておく
				string.append(" ");
			}
		}//文字列表現を返す
		return string.toString();
	}

}
