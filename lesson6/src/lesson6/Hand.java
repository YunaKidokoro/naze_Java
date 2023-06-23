package lesson6;
import java.util.ArrayList;
import java.util.Random;
/**
 * 手札クラス
 * @author yuna
 * @date 2023/6/20
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
	 * カードを一枚引く
	 * @return 引いたカードを返す
	 */
	public Card pickCard() {
		//手札のリストから一枚取り除く
		Card pickedCard = (Card) handList.remove(0);
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
	 * 同じ数字のカードがあればその数字の格納された配列を返却し、
	 * 無かった場合にはnullを返す
	 * @return 数字の同じカードを返す
	 */
	public Card[] findSameNumberCards() {
		//手札の枚数を表す変数
		int numberOfCards = handList.size();
		//数字の同じカードのリスト、同じカードがなかった時がnullとする
		Card [] sameCards = null;
		
		//手札にカードが一枚も無い場合は何もしない
		if(numberOfCards > 0) {
			//最後に追加されたカードのインデックスを取得する
			int lastIndex = numberOfCards -1;
			//最後に追加されたカードを取得する
			Card lastAddCard = (Card) handList.get(lastIndex);
			//最後に追加されたカードの数字を取得する
			int lastAddCardnumber = lastAddCard.getCardNumber();
			
			//配列の先頭から末尾まで順番に走査する
			for(int index=0; index<lastIndex; index++) {
				//今見てるインデックスの位置のカードのインスタンスを生成する
				Card card = (Card) handList.get(index);
				//そのカードの数字が加えたカードの数字と一致した場合
				if(card.getCardNumber() == lastAddCardnumber) {
					//同じカードの配列を要素数２で宣言
					sameCards = new Card[2];
					//配列に最後に加えたカードを手札から取り出して格納する
					sameCards[0] = (Card)handList.remove(lastIndex);
					//配列に見つけた数字の同じカードを手札から取り出して格納
					sameCards[1] = (Card)handList.remove(index);
					//ループから抜ける
					break;
				}
			}
		}//同じカード、またはnullを返す
		return sameCards;
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
