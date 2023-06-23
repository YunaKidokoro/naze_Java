package lesson8;

/**
 * トランプカードクラス<br>
 * カードの数字・スートを見る
 * @author yuna
 * @date 2023/6/21
 */
public class Card {
	/*
	 * クラスの属性
	 * */
	//トランプのスートを表す定数
	public static final int SUIT_HEART   = 1; //ハート
	public static final int SUIT_DIAMOND = 2; //ダイヤ
	public static final int SUIT_SPADE   = 3; //スペード
	public static final int SUIT_CLOVER  = 4; //クローバー
	public static final int SUIT_NUM  = 4; //スートの数
	public static final int CARD_NUM  = 13; //数字の数
	//そのカードのスートが何かを表すフィールド
	protected int cardSuit;
	//そのカードの数字を表すフィールド
	protected int cardNumber ;
	
	/*
	 * コンストラクタ
	 * 
	 * */
	//引数を受け取らないコンストラクタ
	public Card () {}
	//引数にカードのスートと数字を受け取るコンストラクタ
	public Card (int cardSuit, int cardNumber) {
		//スートを表す引数が1~4で無ければハートだったとして初期化する
		if(cardSuit<1 || cardSuit>4) {
			this.cardSuit = 1;
		}
		//適切な数字であればそのままのスートを受け取る
		else {
			this.cardSuit  = cardSuit;
		}
		if(cardNumber<0 || cardNumber>13) {
			this.cardNumber = 1;
		}
		else {
			this.cardNumber= cardNumber;
		}
	}
	
	/**
	 * 任意のカードのスートを取得する
	 * @return スートが何かを返却する
	 */
	public int getSuit() {
		return cardSuit;
	}
	
	/**
	 * カードの数字を確認する
	 * @return カードの数字を返す
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * カードの数字とスートを文字列で表す
	 * @return カードの文字列表現を返す
	 */
	public String toString(){
		//インスタンスを生成する
		StringBuffer string = new StringBuffer();
		//カードの数字が０より大きい場合
		if(cardNumber > 0 && cardNumber<14) {
			//カードのスートで分岐させる
			switch (cardSuit) {
			//スートがハートの場合
			case SUIT_HEART:
				//表示する文字列にHを加える
				string.append("H");
				break;	//分岐から抜ける
				//スートがダイヤの場合
			case SUIT_DIAMOND:
				//表示する文字列にDを加える
				string.append("D");
				break;	//分岐から抜ける
				//スートがスペードの場合
			case SUIT_SPADE:
				//表示する文字列にSを加える
				string.append("S");
				break;	//分岐から抜ける
				//スートがクローバーの場合			
			case SUIT_CLOVER:
				//表示する文字列にCを加える
				string.append("C");
				break;	//分岐から抜ける
				
				//それ以外の場合があれば
			default: break;//分岐から抜ける
			}//スートの分岐の終わり
		
			switch(cardNumber) 
			{
			//カードの数字が１の場合
			case 1:
				//１を表すAを文字列に追加する
				string.append("A");
				break;	//分岐から抜ける
			//カードの数字が１0の場合
			case 10:
				//10を表すTを文字列に追加する
				string.append("T");
				break;	//分岐から抜ける
			//カードの数字が11の場合
			case 11:
				//11を表すJを文字列に追加する
				string.append("J");
				break;	//分岐から抜ける
			//カードの数字が12の場合
			case 12:
				//12を表すQを文字列に追加する
				string.append("Q");
				break;	//分岐から抜ける
			//カードの数字が13の場合
			case 13:
				//13を表すKを文字列に追加する
				string.append("K");
				break;	//分岐から抜ける
			//それ以外の場合
			default: 
				//カードの数字をそのまま文字列に追加する
				string.append(cardNumber); 
				break;	//分岐から抜ける
			}//カードの数字の分岐終わり
		}
		else {
			System.out.println("不適切な数字");
		}
		//カードのスートと数字を示す文字列を返す
		return string.toString();
	}

}
