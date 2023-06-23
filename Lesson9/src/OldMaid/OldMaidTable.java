package OldMaid;

import java.util.ArrayList;

import lesson8.Card;
import lesson8.Table;

/**
 * ババ抜きのテーブルクラス
 * @author yuna
 * @date 2023/6/22
 */
public class OldMaidTable implements Table{
	
	//捨てられたカードを保持しておくためのリスト
	private ArrayList<Card[]> disposedCards = new ArrayList<Card[]>();
	
	
	/**
	 * 捨てるカードを表示して配列に保持する
	 * @param card 捨てるカード
	 * @author yuna
	 */
	@Override
	public void putCard(Card[] card) {
		
		//引数の配列の先頭から末尾までループする
		for (int index = 0; index < card.length; index++) {
			//カードObjectのtoStringメソッドが自動で呼び出される
			System.out.print(card[index]+" ");
		}
		//カードを捨てたことを表示する
		System.out.println("を捨てました");
		//捨てたカードを「捨てられたカードリスト」に追加する
		disposedCards.add(card);

	}

	/**
	 * 捨てられたカードの並べ方
	 * ババ抜きでカードは並べないので、nullを返すことにする
	 */
	@Override
	public Card[][] getCards() {
		
		return null;
	}

}
