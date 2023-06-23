package lesson6;
import java.util.ArrayList;
/**
 * 同じ数字のカードを捨てる場所・テーブルクラス
 * @author yuna
 * @date 2023/6/20
 */
public class Table {
	
	//捨てられたカードを保持しておくためのリスト
	private ArrayList<Card[]> disposedCards = new ArrayList<Card[]>();
	
	/**
	 * 捨てるカードを表示して配列に保持する
	 * @param card 捨てるカードの配列
	 */
	public void disposeCard(Card card[]) {
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
}
