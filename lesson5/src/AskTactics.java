import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 標準入力でじゃんけんの出す手を決める
 * @author yuna
 * @date　2023/6/19
 */
public class AskTactics implements Tactics{
	
	public int readTactics() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nじゃんけんの手を入力してください。");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー\n");
		System.out.print("?");
	
		int playerHand = Player.STONE;
		
		while(true) {
			try
			{
				String inputStr = br.readLine();
				playerHand = Integer.parseInt(inputStr);
				if(	playerHand == Player.STONE
					||
					playerHand == Player.SCISSORS
					||
					playerHand == Player.PAPER)
				{
					break;
				}
				else {
					System.out.println("入力が正しくありません。もう一度入力してください");
					System.out.println("?");
				}
			}
			catch(Exception ex)
			{
				System.out.println("入力が正しくありません。再度入力してください。");
			}
		}
		
		return playerHand;
	}
}
