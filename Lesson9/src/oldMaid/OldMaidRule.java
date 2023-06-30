package oldMaid;
import lesson8.Card;
import lesson8.Hand;
import lesson8.Rule;
import lesson8.Table;

public class OldMaidRule implements Rule{
	/**
	 * テーブルに捨てられるカードを探す<br>
	 * 同じ数字のカードがあればその数字の格納された配列を返却し
	 * @param hand		手札
	 * @param table		テーブル
	 * @return　見つかったカードの組み合わせ、見つからない時はnullを返す
	 */
	@Override
	public Card[] findCandidate(Hand hand, Table table) {
		
		//手札の枚数を表す変数
		int numberOfCards = hand.getNumberOfCards() ;
		//数字の同じカードのリスト、同じカードがなかった時がnullとする
		Card [] findCard = null;
		
		//手札にカードが一枚も無い場合は何もしない
		if(numberOfCards > 0) {
			//最後に追加されたカードのインデックスを取得する
			int lastIndex = numberOfCards -1;
			//最後に追加されたカードを取得する
			Card lastAddCard = hand.lookCard(lastIndex);
			//最後に追加されたカードの数字を取得する
			int lastAddCardNumber = lastAddCard.getCardNumber();
			
			//配列の先頭から末尾まで順番に走査する
			for(int index=0; index<lastIndex; index++) {
				//今見てるインデックスの位置のカードのインスタンスを生成する
				Card card = hand.lookCard(index);
				//そのカードの数字が加えたカードの数字と一致した場合
				if(card.getCardNumber() == lastAddCardNumber) {
					//同じカードの配列を要素数２で宣言
					findCard = new Card[2];
					//配列に最後に加えたカードを手札から取り出して格納する
					findCard[0] = (Card)hand.pickCard(lastIndex);
					//配列に見つけた数字の同じカードを手札から取り出して格納
					findCard[1] = (Card)hand.pickCard(index);
					//ループから抜ける
					break;
				}
			}
		}
		return findCard;
	}
}