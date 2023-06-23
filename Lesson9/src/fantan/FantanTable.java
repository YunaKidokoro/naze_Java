package fantan;

import lesson8.Card;
import lesson8.Table;

/**
 * 七並べのテーブルクラス
 * @author yuna
 * @date 2023/6/21
 */
public class FantanTable implements Table{

	//テーブルに並んだカードを表す配列(4*13)
	private Card[][] tableCard = new Card[Card.SUIT_NUM][Card.CARD_NUM]; 
	
	/**
	 * カードを置く
	 * @param カード,持ってる手札を端から順に0,1,2,,,としてる
	 * @author yuna
	 * @date 2023/6/21
	 */
	@Override
	public void putCard(Card[] card) {
		//手札の1枚目のカードのスートを見る
		int suitNumber = card[0].getSuit();
		//手札の1枚目のカードの数字を見る
		int cardNumber = card[0].getCardNumber(); 
		/*
		 * 手札をテーブルの適切な位置におく
		 * 配列のインデックスは０からなので-1しておく*/
		tableCard[suitNumber-1][cardNumber-1] = card[0];
	}

	/**
	 * カードを見る。
	 * @return テーブルに置かれたカードを表す配列
	 */
	@Override
	public Card[][] getCards() {
		//見せるようにテーブルのカード配列のコピーを作る
		Card[][] tableCopy = new Card[Card.SUIT_NUM][Card.CARD_NUM]; 
		//スートごとにループする（行ループ）
		for(int suit=0; suit<Card.SUIT_NUM; suit++) {
			/*
			 * arraycopy(コピー元配列, コピー元配列のコピー開始位置,
			 * コピー先配列, コピー先配列の開始位置, コピーの個数)
			*/
			System.arraycopy(tableCard[suit], 0, tableCopy[suit], 0, Card.CARD_NUM);
		}
		//テーブルに置かれたカードを表す配列を返す
		return tableCopy;
	}
	
	/**
	 * テーブルのカードを表す文字列表現
	 * @return 	テーブル上のカードの文字列表現を返却する
	 */
	@Override
	public String toString() {
		//StringBunfferを宣言
		StringBuffer tableString = new StringBuffer();
		//スートのループ（行ループ）
		for(int suit=0 ; suit<Card.SUIT_NUM; suit++) {
			//数字のループ（列ループ）
			for(int num=0; num<Card.CARD_NUM; num++) {
				//指定位置のカードがまだ置かれて無いとき
				if(tableCard[suit][num] == null) {
					//代わりに..を表示する
					tableString.append("..");
				}
				//置かれてた場合は
				else {
					//その位置のカードのスートと数字を表示する
					tableString.append(tableCard[suit][num]);
				}
				//隣を表示するまえにスペースを追加する
				tableString.append(" ");
			}
			//次の行に移るために改行をする
			tableString.append("\n");
		}
		//文字列表現を返却する
		return tableString.toString();
	}
	
}
  