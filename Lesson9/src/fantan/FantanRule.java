package fantan;

import lesson8.Card;
import lesson8.Hand;
import lesson8.Rule;
import lesson8.Table;

/**
 * 七並べ用のルールクラス
 * @author yuna
 * @date 2023/6/22
 */
public class FantanRule implements Rule{

	/**
	 * テーブルに出せるカードを探す
	 * @param hand　手札
	 * @param Table テーブルに出てるカード
	 * @return Card[]　テーブルに出せるカードの組み合わせ、なければnullを返す
	 */
	@Override
	public Card[] findCandidate(Hand hand, Table table) {
		//手札の枚数を数える
		int numberOfCards = hand.getNumberOfCards();
		/*
		 * おけるカード候補を格納する配列
		 * おけるカードが無い場合はnullを返す*/
		Card[] findCards = null;
		
		//手札のカードを順に確認する
		for(int index=0; index<numberOfCards; index++) {
			//手札のカードを見る
			Card lookingCard = hand.lookCard(index);
			//見てるカードのスートを確認する
			int lookingSuit = lookingCard.getSuit();
			//見てるカードの数字を確認する
			int lookingNum  = lookingCard.getCardNumber();
		
			//見てるカードの右隣の数字
			int rightNum = lookingNum+1; 
			//見てるカードの左隣の数字
			int leftNum = lookingNum-1;
			
			//見てるカードが１の場合
			if(lookingNum == 1) {
				//左隣のカードは13になる
				leftNum = 13;
			}
			//見てるカードが13の場合
			else if(lookingNum == 13) {
				//右隣のカードは1になる
				rightNum=1;
			}
			//置きたいカードと隣接するカードがテーブルにおかれている場合
			if(isThereCard(table,lookingSuit,rightNum)
				||isThereCard(table,lookingSuit,leftNum)) {
				//見てるカードをおけるカードの配列に格納する
				findCards = new Card[1];
				//カードを手札から引く
				findCards[0] = hand.pickCard(index);
				break;
			}
		}
		//出せるカードのうち最初に見つかったものを返却する
		return findCards;
	}
	
	
	/**
	 * 引数で指定した位置のカードが置かれるかどうか調べる
	 * @param table テーブル
	 * @param cardSuit　スート
	 * @param cardNumber　数字
	 * @return　カードが置かれている場合はtrueを返す
	 */
	private boolean isThereCard(Table table, int cardSuit, int cardNumber) {
		//テーブルにカードがなかった場合はfalseを返す
		boolean result= false;
		//テーブル上のカードを取得する
		Card[][] tableCards = table.getCards();
		
		//指定したスートと数の位置に配列要素がある場合
		if(tableCards[cardSuit-1][cardNumber-1] != null) {
			//カードがあった場合はtrue
			result = true;
		}
		//カードがあったかどうかを返却する
		return result;
	}

}